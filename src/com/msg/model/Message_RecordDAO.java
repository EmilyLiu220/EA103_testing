package com.msg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Message_RecordDAO implements Message_RecordDAOI{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/G7_PROJECT");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_MSG = "INSERT INTO MESSAGE_RECORD (MSG_NO,EMP_NO,MEM_NO,MSG_CONT,MSG_STS) VALUES ('MN'||to_char(SEQ_MSG_NO.nextval,'FM00000000'), ?, ?, ?, ?)"; 
	private static final String GET_BY_MEMNO = "SELECT EMP_NO, MSG_CONT, MSG_TIME, MSG_STS FROM MESSAGE_RECORD WHERE MEM_NO=? ORDER BY MSG_NO"; 
	
	@Override
	public void insert(Message_RecordVO msgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_MSG);
			pstmt.setString(1, msgVO.getEmpNo());
			pstmt.setString(2, msgVO.getMemNo());
			pstmt.setString(3, msgVO.getMsgCont());
			pstmt.setInt(4, msgVO.getMsgSts());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public List<Message_RecordVO> findByMemNo(String memNo) {
		List<Message_RecordVO> list = new ArrayList<Message_RecordVO>();
		Message_RecordVO msgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_MEMNO);
			pstmt.setString(1, memNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				msgVO = new Message_RecordVO();
				msgVO.setEmpNo(rs.getString("EMP_NO"));
				msgVO.setMsgCont(rs.getString("MSG_CONT"));
				msgVO.setMsgTime(rs.getDate("MSG_TIME"));
				msgVO.setMsgSts(rs.getInt("MSG_STS"));
				list.add(msgVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}

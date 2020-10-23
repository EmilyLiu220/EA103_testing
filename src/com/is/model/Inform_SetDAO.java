package com.is.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Inform_SetDAO implements Inform_SetDAOI{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/G7_PROJECT");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_IS_STMT = "INSERT INTO INFORM_SET (IS_NO,EMP_NO,IS_CONT,IS_DATE) VALUES ('IS'||to_char(SEQ_IS_NO.nextval,'FM00000000'), ?, ?, ?)"; 
	private static final String UPDATE_IS_STMT = "UPDATE INFORM_SET SET EMP_NO=?, IS_CONT=?, IS_DATE=? WHERE IS_NO=?"; 	
	private static final String DELETE_IS_STMT = "DELETE FROM INFORM_SET WHERE IS_NO=?"; 
	private static final String GET_BY_ISNO = "SELECT IS_NO, IS_CONT, IS_DATE, EMP_NO FROM INFORM_SET WHERE IS_NO=?"; 
	private static final String GET_BY_EMPNO = "SELECT IS_NO, IS_CONT, IS_DATE, EMP_NO FROM INFORM_SET WHERE EMP_NO=? ORDER BY IS_NO DESC"; 
	private static final String GET_BY_VAGUE = "SELECT IS_NO, IS_CONT, IS_DATE, EMP_NO FROM INFORM_SET WHERE IS_CONT LIKE ? ORDER BY IS_NO DESC"; 
	private static final String GET_BY_DATE = "SELECT IS_NO, IS_CONT, IS_DATE, EMP_NO FROM INFORM_SET WHERE IS_DATE BETWEEN to_date(?,'yyyy-mm-dd') AND to_date(?,'yyyy-mm-dd') ORDER BY IS_DATE DESC"; 	
	private static final String GET_ALL = "SELECT IS_NO, IS_CONT, IS_DATE, EMP_NO FROM INFORM_SET ORDER BY IS_NO DESC"; 
	
	@Override
	public void insert(Inform_SetVO isVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_IS_STMT);
			pstmt.setString(1, isVO.getEmpNo());
			pstmt.setString(2, isVO.getIsCont()); 
			pstmt.setDate(3, isVO.getIsDate());
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
	public void update(Inform_SetVO isVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_IS_STMT);
			pstmt.setString(1, isVO.getEmpNo());
			pstmt.setString(2, isVO.getIsCont());
			pstmt.setDate(3, isVO.getIsDate());
			pstmt.setString(4, isVO.getIsNo());
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
	public void delete(String isNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_IS_STMT);
			pstmt.setString(1, isNo);
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
	public Inform_SetVO findByIsNo(String isNo) {
		Inform_SetVO isVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_ISNO);
			pstmt.setString(1, isNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isVO = new Inform_SetVO();
				isVO.setIsNo(rs.getString("IS_NO"));
				isVO.setIsCont(rs.getString("IS_CONT"));
				isVO.setIsDate(rs.getDate("IS_DATE"));
				isVO.setEmpNo(rs.getString("EMP_NO"));
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
		return isVO;
	}

	@Override
	public List<Inform_SetVO> findByEmpNo(String empNo) {
		List<Inform_SetVO> list = new ArrayList<Inform_SetVO>();
		Inform_SetVO isVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_EMPNO);
			pstmt.setString(1, empNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isVO = new Inform_SetVO();
				isVO.setIsNo(rs.getString("IS_NO"));
				isVO.setIsCont(rs.getString("IS_CONT"));
				isVO.setIsDate(rs.getDate("IS_DATE"));
				isVO.setEmpNo(rs.getString("EMP_NO"));
				list.add(isVO);
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
	

	@Override
	public List<Inform_SetVO> findByIsCont(String isCont) {
		List<Inform_SetVO> list = new ArrayList<Inform_SetVO>();
		Inform_SetVO isVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_VAGUE);
			pstmt.setString(1, '%'+isCont+'%');
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isVO = new Inform_SetVO();
				isVO.setIsNo(rs.getString("IS_NO"));
				isVO.setIsCont(rs.getString("IS_CONT"));
				isVO.setIsDate(rs.getDate("IS_DATE"));
				isVO.setEmpNo(rs.getString("EMP_NO"));
				list.add(isVO);
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
	
	@Override
	public List<Inform_SetVO> findByDate(Date startDate, Date stopDate) {
		List<Inform_SetVO> list = new ArrayList<Inform_SetVO>();
		Inform_SetVO isVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_BY_DATE);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, stopDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isVO = new Inform_SetVO();
				isVO.setIsNo(rs.getString("IS_NO"));
				isVO.setIsCont(rs.getString("IS_CONT"));
				isVO.setIsDate(rs.getDate("IS_DATE"));
				isVO.setEmpNo(rs.getString("EMP_NO"));
				list.add(isVO);
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

	@Override
	public List<Inform_SetVO> getAll() {
		List<Inform_SetVO> list = new ArrayList<Inform_SetVO>();
		Inform_SetVO isVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				isVO = new Inform_SetVO();
				isVO.setIsNo(rs.getString("IS_NO"));
				isVO.setIsCont(rs.getString("IS_CONT"));
				isVO.setIsDate(rs.getDate("IS_DATE"));
				isVO.setEmpNo(rs.getString("EMP_NO"));
				list.add(isVO);
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

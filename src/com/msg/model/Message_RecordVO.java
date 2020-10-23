package com.msg.model;

import java.io.Serializable;

public class Message_RecordVO implements Serializable{
	
	private static final long serialVersionUID = 2869485720871607525L;
	
	private String msgNo;
	private String empNo;
	private String memNo;
	private String msgCont;
	private java.sql.Date msgTime;
	private int msgSts;

	public String getMsgNo() {
		return msgNo;
	}
	
	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getMemNo() {
		return memNo;
	}
	
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	
	public String getMsgCont() {
		return msgCont;
	}
	
	public void setMsgCont(String msgCont) {
		this.msgCont = msgCont;
	}
	
	public java.sql.Date getMsgTime() {
		return msgTime;
	}
	
	public void setMsgTime(java.sql.Date msgTime) {
		this.msgTime = msgTime;
	}
	
	public int getMsgSts() {
		return msgSts;
	}
	
	public void setMsgSts(int msgSts) {
		this.msgSts = msgSts;
	}
	
}

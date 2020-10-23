package com.fi.model;

import java.io.Serializable;

public class Front_InformVO implements Serializable{
	
	private static final long serialVersionUID = -2880126589862278310L;
	
	private String infoNo;
	private String memNo;
	private String infoCont;
	private java.sql.Date infoDate;
	private int infoSts;
	private String resNo;
	
	public String getInfoNo() {
		return infoNo;
	}
	
	public void setInfoNo(String infoNo) {
		this.infoNo = infoNo;
	}
	
	public String getMemNo() {
		return memNo;
	}
	
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	
	public String getInfoCont() {
		return infoCont;
	}
	
	public void setInfoCont(String infoCont) {
		this.infoCont = infoCont;
	}
	
	public java.sql.Date getInfoDate() {
		return infoDate;
	}
	
	public void setInfoDate(java.sql.Date infoDate) {
		this.infoDate = infoDate;
	}
	
	public int getInfoSts() {
		return infoSts;
	}
	
	public void setInfoSts(int infoSts) {
		this.infoSts = infoSts;
	}
	
	public String getResNo() {
		return resNo;
	}
	
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	
}

package com.is.model;

import java.io.Serializable;

public class Inform_SetVO implements Serializable{

	private static final long serialVersionUID = -8947956968263648314L;

	private String isNo;
	private String empNo;
	private String isCont;
	private java.sql.Date isDate;
	
	public String getIsNo() {
		return isNo;
	}
	
	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public String getIsCont() {
		return isCont;
	}
	
	public void setIsCont(String isCont) {
		this.isCont = isCont;
	}
	
	public java.sql.Date getIsDate() {
		return isDate;
	}
	
	public void setIsDate(java.sql.Date isDate) {
		this.isDate = isDate;
	}
	
}

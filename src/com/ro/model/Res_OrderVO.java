package com.ro.model;

import java.io.Serializable;

public class Res_OrderVO implements Serializable{

	private static final long serialVersionUID = 4374929277208257942L;
	private String resNo;
	private String memNo;
	private String resDate;
	private String timePeriNo;
	
	public String getResNo() {
		return resNo;
	}
	
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	
	public String getMemNo() {
		return memNo;
	}
	
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	
	public String getResDate() {
		return resDate;
	}
	
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	
	public String getTimePeriNo() {
		return timePeriNo;
	}
	
	public void setTimePeriNo(String timePeriNo) {
		this.timePeriNo = timePeriNo;
	}
	
}

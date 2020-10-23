package com.mem.model;

import java.io.Serializable;

public class MemVO implements Serializable{
	
	private static final long serialVersionUID = -2181192612617754022L;
	private String memNo;
	private String memName;
	
	public String getMemNo() {
		return memNo;
	}
	
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	
	public String getMemName() {
		return memName;
	}
	
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
}

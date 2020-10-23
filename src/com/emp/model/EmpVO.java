package com.emp.model;

import java.io.Serializable;

public class EmpVO implements Serializable{

	private static final long serialVersionUID = -1787739322168367097L;
	private String empNo;
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

}

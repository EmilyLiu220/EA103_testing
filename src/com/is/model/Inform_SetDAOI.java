package com.is.model;

import java.util.List;

public interface Inform_SetDAOI {
	
	public void insert(Inform_SetVO isVO);
	public void update(Inform_SetVO isVO);
	public void delete(String isNo);
	public Inform_SetVO findByIsNo(String isNo);
	public List<Inform_SetVO> findByEmpNo(String empNo);
	public List<Inform_SetVO> findByIsCont(String isCont);
	public List<Inform_SetVO> findByDate(java.sql.Date startDate, java.sql.Date stopDate);
    public List<Inform_SetVO> getAll();

}

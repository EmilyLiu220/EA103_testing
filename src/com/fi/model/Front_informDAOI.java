package com.fi.model;

import java.util.*;

import com.ro.model.Res_OrderVO;

public interface Front_informDAOI{
	
	public void insertInfo(String memNo, String infoCont);
	public void insertFromRO(Res_OrderVO resOrd, String infoCont);
	public void insertResCheInform(String resNo);
	public void updateSts(Front_InformVO fiVO);
	public List<Front_InformVO> getAll(String memNo);
	
}

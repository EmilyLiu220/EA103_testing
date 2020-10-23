package com.msg.model;

import java.util.List;

public interface Message_RecordDAOI {
	
	public void insert(Message_RecordVO msgVO);	
	public List<Message_RecordVO> findByMemNo(String memNo);
	
}

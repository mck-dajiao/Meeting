package com.soft.meetmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.dao.EmpFenyeDao;

public class FyService {
	
	EmpFenyeDao fyDao = new EmpFenyeDao();
	
	public List pageSum(String username1,String employeename1){
		List list = new ArrayList();
		list = fyDao.pageSum(username1, employeename1);
		return list;
	}
	
	public List search(String username1, String employeename1,
			int  sizeBegin, int sizeEnd){
		List list = new ArrayList();
		list = fyDao.search(username1, employeename1, sizeBegin, sizeEnd);
		return list;
	}
}

package com.soft.meetmanager.service;

import java.util.List;

import com.soft.meetmanager.dao.SelectmymeetingDAO;

public class MymeetingService {
 public List myMeet(int userid){
	 SelectmymeetingDAO  mydao = new SelectmymeetingDAO();
		List list = mydao.selectMymeet(userid);
		return list;
 }
}

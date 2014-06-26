package com.soft.meetmanager.service;

import java.util.List;

import com.soft.meetmanager.dao.SelectMeetingDao;

public class MyBookingService {
public List  myBook(int userid){
	SelectMeetingDao mydao = new SelectMeetingDao();
	List list = mydao.selectMymt(userid);
	return list;
}
}

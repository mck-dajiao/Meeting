package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.MyMeetingDAO;
import com.dajiao.model.Meeting;

public class MyMeetingService {

	public MyMeetingService() {
		// TODO Auto-generated constructor stub
	}

	public static List<Meeting> getMyMeeting(String useraccount){
		return MyMeetingDAO.getMyMeeting(useraccount);
	}
}

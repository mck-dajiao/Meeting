package com.dajiao.service;

import com.dajiao.dao.MyBookingDAO;
import com.dajiao.dao.NotificationDAO;
import com.dajiao.model.Meeting;

import java.util.List;

public class MyBookingService {

	public MyBookingService() {
		// TODO Auto-generated constructor stub
	}

	public static List<Meeting> getMyBooking(String useraccount){
		System.out.println("getMyBooking useraccount");
		return MyBookingDAO.getMyBooking(useraccount);
	}
	
	public static boolean modifyMeeting(Meeting meeting){
		
		if(NotificationDAO.modifyMessage(meeting))
			System.out.println("send modify message ");
		return MyBookingDAO.modifyMeeting(meeting);
	}
	
	public static boolean applyEquitment(int meetingId, int a, int b, int c){
		return MyBookingDAO.applyEquitment(meetingId, a, b, c);
	}
	
	public static boolean submitSummary(int meetingId, String summary){
		return MyBookingDAO.submitSummary(meetingId, summary);
	}
}

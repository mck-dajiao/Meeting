package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.NotificationDAO;
import com.dajiao.model.MeetingRecord;
import com.dajiao.model.Notification;

public class NotificationService {

	public NotificationService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Notification> getInviteMessage(String useraccount){
		return NotificationDAO.getInviteList(useraccount);
	}
	
	public static List<Notification> getChangeMessage(String useraccount){
		return NotificationDAO.getChangeInfoList(useraccount);
	}
	
	public static List<MeetingRecord> getSummaryMessage(String useraccount){
		return NotificationDAO.getRecordList(useraccount);
	}
	
	public static boolean agreeInvite(int meetingId, String account){
		return NotificationDAO.agreeInvite(meetingId, account);
	}
	
	public static boolean disagreeInvite(int meetingId, String account){
		return NotificationDAO.disagreeInvite(meetingId, account);
	}

}

package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.NotificationDAO;
import com.dajiao.model.Notification;

public class NotificationService {

	public NotificationService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Notification> getInviteMessage(String useraccount){
		return NotificationDAO.getInviteList(useraccount);
	}
	
	

}

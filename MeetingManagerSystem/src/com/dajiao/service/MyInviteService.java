package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.MyInviteDAO;
import com.dajiao.model.User;

public class MyInviteService {

	public MyInviteService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> getInviteList(int meetingId){
		return MyInviteDAO.getInviteList(meetingId);
	}
	
	public static List<User> getUserList(String name, String sex, String department){
		return null;
	}

	public static boolean deleteUser(String[] list){
		return false;
	}
	
	public static boolean inviteUser(String[] list){
		return false;
	}
}

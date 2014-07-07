package com.dajiao.dao;

import java.util.List;
import java.util.Map;

import com.dajiao.model.User;

public class MyInviteDAO {

	public MyInviteDAO() {
		// TODO Auto-generated constructor stub
	}

	public static List<User> getInviteList(int meetingId){
		// 通过meeting id获取已经被邀请参会的人员
		return null;
	}
	
	public static boolean deleteFromInvite(int meetingId, int id){
		// 通过meeting id和User id撤销对某人的邀请
		return false;
	}
	
	public static boolean inviteUser(List<Integer> list){
		// 通过meeting id和User id来邀请某人参加会议,其中list中基数位和偶数位一一对应，偶数为meeting id，基数为User id
		return false;
	}
}

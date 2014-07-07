package com.dajiao.dao;

import java.util.List;

import com.dajiao.model.User;

public class AdApprovalDAO {

	public AdApprovalDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> getUnapprovalList(){
		// 获取所有的未审批的用户列表
		return null;
	}  
	
	public static boolean acceptUser(List<String> list){
		// 把列表中所有的User id都允许通过审批
		return false;
	}
	
	public static boolean rejectUser(List<String> list){
		// 拒绝User 并从数据库中删除
		return false;
	}

}

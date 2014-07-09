package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.AdApprovalDAO;
import com.dajiao.model.User;

public class AdApprovalService {

	public AdApprovalService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> getUnapproval(){
		return AdApprovalDAO.getUnapprovalList();
	}

	public static boolean agreeUserList(String[] accountList){
		return AdApprovalDAO.acceptUser(accountList);
	}
	
	public static boolean disagreeUserList(String[] accountList){
		return AdApprovalDAO.rejectUser(accountList);
	}
}

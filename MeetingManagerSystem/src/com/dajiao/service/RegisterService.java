package com.dajiao.service;

import com.dajiao.dao.RegisterDAO;
import com.dajiao.model.User;

public class RegisterService {

	public RegisterService() {
		// TODO Auto-generated constructor stub
	}

	public static boolean register(User user, String password){
		return RegisterDAO.insertNewUser(user, password);
	}
}

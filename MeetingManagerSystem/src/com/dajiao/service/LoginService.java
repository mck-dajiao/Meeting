package com.dajiao.service;

import com.dajiao.model.*;
import com.dajiao.dao.*;

public class LoginService {
	
	public static Person validate(String username, String password){
		
		//@TODO multi administrator account 
		if(username.equals("admin")){
			return LoginDAO.validateAdmin(username, password);
		}else{
			return LoginDAO.validateUser(username, password);
		}
		
	}

}

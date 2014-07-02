package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dajiao.model.User;
import com.dajiao.util.ConnectionFactory;

public class RegisterDAO {

	public RegisterDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean insertNewUser(User user, String password){
		
		Connection conn = ConnectionFactory.getConnection();
		
		
		
		if(conn==null) return false;
		
		try {
			PreparedStatement pSt = null;
			String sql = "insert into User(account,password,name,department,status) values(?,?,?,?,?)";
			pSt = conn.prepareStatement(sql);
			pSt.setString(1, user.getaccount());
			pSt.setString(2, password);
			pSt.setString(3, user.getname());
			pSt.setString(4, user.getDepartment());
			pSt.setString(5, user.getStatus());
			int result = pSt.executeUpdate();
			if(result == 1)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
		
		return false;
	}

}

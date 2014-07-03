package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dajiao.model.*;
import com.dajiao.util.*;

public class LoginDAO {
	
		public static Administrator validateAdmin(String account, String password){
			
			Connection conn = ConnectionFactory.getConnection();
			
			try {
				PreparedStatement pSt = null;
				String sql = "select * from admin where account='" + account + 
						"' and password='" + password + "'";
				pSt = conn.prepareStatement(sql);
				ResultSet rs = pSt.executeQuery(sql);
				if(rs.next()==true){
					return new Administrator(account);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
						
			return null;
		}
	
		public static User validateUser(String account, String password){
			
			Connection conn = ConnectionFactory.getConnection();
			
			if(conn==null) return null;
			try {
				PreparedStatement pSt = null;
				String sql = "select * from user where account='" + account + 
						"' and password='" + password + "' and status='approvaled'";
				pSt = conn.prepareStatement(sql);
				ResultSet rs = pSt.executeQuery(sql);
				
				if(rs.next()==true){
					System.out.println(rs.getString(6));
					User user = new User(account);
					user.setname(rs.getString(4));
					user.setDepartment(rs.getString(5));
					user.setStatus("approvaled");
					return user;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
						
			return null;
		}
		
}

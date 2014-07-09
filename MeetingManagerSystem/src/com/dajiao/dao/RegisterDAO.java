package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dajiao.model.User;
import com.dajiao.util.ConnectionFactory;

public class RegisterDAO {

	public RegisterDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean insertNewUser(User user, String password){
		
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return false;

		try {
			PreparedStatement pSt = null;
			String sql = "insert into User(userid,account,password,name,sex,department,anhao) values('"
					+ user.getUserid()
					+ "','"
					+ user.getAccount()
					+ "','"
					+ password
					+ "','"
					+ user.getName()
					+ "','"
					+ user.getSex()
					+ "','"
					+ user.getDepartment()
					+ "','"
					+ user.getAnhao()
					+ "')";
			pSt = conn.prepareStatement(sql);
			System.out.println("resister userid" + user.getUserid()
					+ " account " + user.getAccount() + " name "
					+ user.getName() + " sex " + user.getSex() + " department "
					+ user.getDepartment() + " anhao " + user.getAnhao());
			int result = pSt.executeUpdate();
			if (result == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}

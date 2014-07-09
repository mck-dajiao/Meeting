package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.User;
import com.dajiao.util.ConnectionFactory;

public class AdApprovalDAO {

	public AdApprovalDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> getUnapprovalList(){
		List<User> list = new ArrayList<User>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select account,name,department,anhao,userid from user where status='unapprovaled'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				User user = new User();
				user.setaccount(set.getString(1));
				user.setName(set.getString(2));
				user.setDepartment(set.getString(3));
				user.setAnhao(set.getString(4));
				user.setUserid(set.getString(5));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}  
	
	public static boolean acceptUser(String[] list){
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = null;
			for (int i = 0; i < list.length; i++) {
				sql = "update user set status='approvaled' where account='"
						+ list[i] + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 0)
					return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean rejectUser(String[] list){
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = null;
			for (int i = 0; i < list.length; i++) {
				sql = "delete from user where account='" + list[i] + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 0)
					return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dajiao.model.User;
import com.dajiao.util.ConnectionFactory;

public class MyInviteDAO {

	public MyInviteDAO() {
		// TODO Auto-generated constructor stub
	}


	
	public static List<User> getInviteList(int meetingId) {
		// 通过meeting id获取已经被邀请参会的人员
		List<User> list = new ArrayList<User>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			// test
			System.out.println("before sql0" );
			
			String sql = "select account from invite where meetingid="
					+ meetingId + "";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			
			// test
			System.out.println("before while" );
			
			while (set.next() == true) {
				
				// test
				System.out.println("before sql1" );
				
				
				String sql1 = "select userid,account,name,sex,department,anhao from user where account='"
						+ set.getString(1) + "'";
				PreparedStatement ps = connection.prepareStatement(sql1);
				ResultSet rs = ps.executeQuery(sql1);

				while(rs.next() == true){
					User user = new User();
					user.setUserid(rs.getString(1));
					user.setaccount(rs.getString(2));
					user.setName(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setDepartment(rs.getString(5));
					user.setAnhao(rs.getString(6));
					
					// test
					System.out.println("add user " + user.getAccount());
					
					list.add(user);
				}
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean deleteInvite(String account, int meetingId){
		 Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = "delete from invite where account='" + account
						+ "' and meetingid=" + meetingId + "";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 1)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

	}
	
	public static boolean deleteFromInvite(int meetingId, int id) {
		// 通过meeting id和User id撤销对某人的邀请
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "select account from user where userid=" + id + "";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				String sql1 = "delete from invite where meetingid=" + meetingId
						+ " and account='" + set.getString(1) + "'";
				PreparedStatement ps = connection.prepareStatement(sql1);
				int rs = ps.executeUpdate(sql1);
				if (rs == 1)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean inviteUser(String[] account, int meetingid) {
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			for (int i = 0; i < account.length; i++) {
				String sql = "insert into invite(account,meetingid) values('"
						+ account[i] + "'," + meetingid + ")";
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
	
	  public static String getTopicByMeetingid(int meetingId) {
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select topic from meeting where meetingid="
						+ meetingId + "";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					return set.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
}

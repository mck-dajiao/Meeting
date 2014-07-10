package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.User;
import com.dajiao.util.ConnectionFactory;

public class EmployeeManagerDAO {

	public EmployeeManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	 public static List<User> getAllUser() {
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					
					//test
					System.out.println("get user " + user.getAccount());
					
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static List<User> getUser(int num) {
			// 获取数据库中前num个数据
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled' limit 0,"
						+ num + "";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static List<User> getUserByName(String name) {
			// 根据名字获取用户列表
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled' and name='"
						+ name + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static User getUserById(String userid) {
			// 根据userid获取用户列表
			User user = new User();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled' and userid='"
						+ userid + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					return user;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static List<User> getUserByDepartmentName(String departmentName) {
			// 根据部门获取用户列表
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled' and department='"
						+ departmentName + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static boolean deleteUser(String account) {
			// 删除用户
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = null;
				sql = "delete from user where account='" + account + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 0)
					return false;
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean addUser(User user) {
			// 添加用户
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = null;
				sql = "insert into user(userid,account,name,sex,department,anhao) values('"
						+ user.getUserid()
						+ "','"
						+ user.getaccount()
						+ "','"
						+ user.getName()
						+ "','"
						+ user.getSex()
						+ "','"
						+ user.getDepartment() + "','" + user.getAnhao() + "')";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 0)
					return false;
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean modify(User user) {
			// 修改用户
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = null;

				sql = "update user set userid='" + user.getUserid() + "',account='"
						+ user.getAccount() + "',name='" + user.getName()
						+ "',sex='" + user.getSex() + "', department='"
						+ user.getDepartment() + "',anhao='" + user.getAnhao()
						+ "' where account='" + user.getaccount() + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				int set = pStatement.executeUpdate(sql);
				if (set == 0)
					return false;
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean deleteUser(String[] userList) {
			// 字符串数组
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = null;
				for (int i = 0; i < userList.length; i++) {
					sql = "delete from user where account='" + userList[i] + "'";
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
		

		public static List<User> getUserBySex(String sex) {
			// 根据名字获取用户列表
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where status='approvaled' and sex='"
						+ sex + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));
					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static List<User> getAllUserWithoutInvite(int meetingId){
			List<User> list = new ArrayList<User>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select * from user where account not in(	select account from invite	where meetingid="
						+ meetingId + ")";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					User user = new User();
					user.setUserid(set.getString(1));
					user.setaccount(set.getString(2));
					user.setName(set.getString(4));
					user.setSex(set.getString(5));
					user.setDepartment(set.getString(6));
					user.setAnhao(set.getString(8));

					// test
					System.out.println("get user " + user.getAccount());

					list.add(user);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}

package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.Department;
import com.dajiao.util.ConnectionFactory;

public class DepartmentManagerDAO {

	public DepartmentManagerDAO() {
		// TODO Auto-generated constructor stub
	}

	public static List<Department> getAllDepartment() {

		// 获得所有的部门信息
		List<Department> list = new ArrayList<Department>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select * from department";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				Department department = new Department();
				department.setId(set.getInt(1));
				department.setName(set.getString(2));
				list.add(department);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean modifyDepartment(Department department) {
		// 修改部门信息
		List<Department> list = new ArrayList<Department>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "update department set departmentid="
					+ department.getId() + " departmentname="
					+ department.getName() + "";
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

	public static boolean deleteDepartment(String[] value) {
		// 删除部门，删除前确保部门没人
		List<Department> list = new ArrayList<Department>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;

		PreparedStatement pStatement = null;
		ResultSet set = null;
		try {
			int rs = 1;
			for (String str : value) {
				int id = Integer.parseInt(str);
				String sql = "select count(*) from department inner join user on department.departmentname=user.department where department.departmentid="
						+ id + "";
				pStatement = connection.prepareStatement(sql);
				set = pStatement.executeQuery(sql);
				while (set.isClosed()==false && set.next() == true) {
					if (set.getInt(1) == 0) {
						sql = "delete from department where departmentid=" + id
								+ "";
						rs = pStatement.executeUpdate(sql)&rs;
					}
				}
			}
			if(rs==1) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addDepartment(Department department) {
		// 添加部门,确保名字不重复
		List<Department> list = new ArrayList<Department>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "select count(*) from department inner join user on department.departmentname=user.department where department.departmentid="
					+ department.getId()
					+ " and department.departmentname='"
					+ department.getName() + "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				if (set.getInt(1) == 0) {
					sql = "insert into department(departmentid,departmentname) values("
							+ department.getId()
							+ ",'"
							+ department.getName()
							+ "')";
					int rs = pStatement.executeUpdate(sql);
					if (rs == 1)
						return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

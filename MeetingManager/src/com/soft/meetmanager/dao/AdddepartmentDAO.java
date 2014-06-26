package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.soft.meetmanager.model.Department;
import com.soft.meetmanager.util.ConnectionFactory;

public class AdddepartmentDAO {
public int insert(Department Dp){
	
	int islog=0;
	//获得一个连接
	Connection conn=ConnectionFactory.getConnection();
	//写插入的语句
	String sql="insert into department (departmentname)"+"values(?)";
	try {
		PreparedStatement ql=conn.prepareStatement(sql);
		
		    ql.setString(1, Dp.getDepartmentname());
		//开始并提交事物
		    int i = ql.executeUpdate();
		    if(i != 0){
		    	System.out.println("Insert Success!");
		    }
		   // System.out.println(Dp.getDepartmentname());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return islog;
	
}
//	public static void main(String[] args) {
//		new AdddepartmentDAO().insert(null);
//	}
}

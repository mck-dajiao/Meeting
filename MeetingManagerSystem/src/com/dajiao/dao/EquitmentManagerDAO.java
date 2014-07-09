package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.Borrow;
import com.dajiao.util.ConnectionFactory;

public class EquitmentManagerDAO {

	public EquitmentManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Borrow> getBorrowList() {
		// 获取借用表，未归还的和未批准的
		List<Borrow> list = new ArrayList<Borrow>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select borrowid,bookpeople,meeting.starttime,anum,bnum,cnum,borrow.status from borrow inner join meeting on borrow.meetingid=meeting.meetingid";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				Borrow borrow = new Borrow();
				borrow.setId(set.getInt(1));
				borrow.setBorrower(set.getString(2));
				borrow.setDate(set.getTimestamp(3));
				borrow.setaNum(set.getInt(4));
				borrow.setbNum(set.getInt(5));
				borrow.setcNum(set.getInt(6));
				borrow.setStatus(set.getString(7));
				list.add(borrow);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean approval(int id) {
		// 同意借出
		List<Borrow> list = new ArrayList<Borrow>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "update borrow set status='borrowed' where borrowid="
					+ id + "";
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

	public static boolean giveBack(int id) {
		// 归还
		List<Borrow> list = new ArrayList<Borrow>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "delete from borrow where borrowid=" + id + "";
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

	public static Borrow getBorrowById(int id) {
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select borrowid,bookpeople,meeting.starttime,anum,bnum,cnum,borrow.status from borrow inner join meeting on borrow.meetingid=meeting.meetingid where borrow.borrowid="
					+ id + "";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			if (set.next() == true) {
				Borrow borrow = new Borrow();
				borrow.setId(set.getInt(1));
				borrow.setBorrower(set.getString(2));
				borrow.setDate(set.getTimestamp(3));
				borrow.setaNum(set.getInt(4));
				borrow.setbNum(set.getInt(5));
				borrow.setcNum(set.getInt(6));
				borrow.setStatus(set.getString(7));
				return borrow;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

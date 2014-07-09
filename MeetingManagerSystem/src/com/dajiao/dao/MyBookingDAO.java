package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.Meeting;
import com.dajiao.util.ConnectionFactory;

public class MyBookingDAO {

	public MyBookingDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Meeting> getMyBooking(String useraccount) {
		List<Meeting> list = new ArrayList<Meeting>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select meeting.meetingid,meeting.bookpeople,meeting.topic,meetingroom.meetingroomid,meetingroom.name,meeting.starttime,meeting.endtime,notification.detail from meeting inner join meetingroom on meetingroom.meetingroomid=meeting.meetingroomid inner join notification on notification.meetingid=meeting.meetingid inner join user on user.name=meeting.bookpeople where user.account='"
					+ useraccount + "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				Meeting meeting = new Meeting();
				meeting.setId(set.getInt(1));
				meeting.setBookpeople(set.getString(2));
				meeting.setTopic(set.getString(3));
				meeting.setMeetingRoom(set.getInt(4));
				meeting.setRoomName(set.getString(5));
				meeting.setStarttime(set.getTimestamp(6));
				meeting.setEndtime(set.getTimestamp(7));
				meeting.setDetail(set.getString(8));
				list.add(meeting);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean modifyMeeting(Meeting meeting) {
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "select meetingroomid from meetingroom where name='"
					+ meeting.getRoomName() + "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			if (set.next() == true) {
				int meetingroomid = set.getInt(1);
				sql = "update meeting set topic='" + meeting.getTopic()
						+ "',meetingroomid=" + meetingroomid + ",starttime='"
						+ meeting.getStarttime() + "',endtime='"
						+ meeting.getEndtime() + "' where meetingid="
						+ meeting.getId() + "";
				pStatement = connection.prepareStatement(sql);
				int rs = pStatement.executeUpdate(sql);
				if (rs == 0)
					return false;
				sql = "update notification set detail='" + meeting.getDetail()
						+ "'where meetingid=" + meeting.getId() + "";
				pStatement = connection.prepareStatement(sql);
				rs = pStatement.executeUpdate(sql);
				if (rs == 0)
					return false;
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	 public static boolean applyEquitment(int meetingId, int a, int b, int c) {
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = "insert into borrow(meetingid,anum,bnum,cnum)values ("
						+ meetingId + "," + a + "," + b + "," + c + ")";
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

		public static boolean submitSummary(int meetingId, String summary) {
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return false;
			try {
				String sql = "insert into summary(meetingid,detail) values("
						+ meetingId + ",'" + summary + "')";
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

}

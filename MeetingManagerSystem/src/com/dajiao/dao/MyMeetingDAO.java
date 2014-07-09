package com.dajiao.dao;

import com.dajiao.model.Meeting;
import com.dajiao.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyMeetingDAO {

	public MyMeetingDAO() {
		// TODO Auto-generated constructor stub
	}
	
	 public static List<Meeting> getMyMeeting(String useraccount) {
			List<Meeting> list = new ArrayList<Meeting>();
			Connection connection = ConnectionFactory.getConnection();
			if (connection == null)
				return null;
			try {
				String sql = "select meeting.meetingid,meeting.bookpeople,meeting.topic,meetingroom.meetingroomid"
						+ ",meetingroom.name,meeting.starttime,meeting.endtime,notification.detail from meeting inner join meetinguser on meetinguser.meetingid=meeting.meetingid inner join meetingroom on meetingroom.meetingroomid=meeting.meetingroomid inner join notification on notification.meetingid=meeting.meetingid where meetinguser.useraccount='"
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

}

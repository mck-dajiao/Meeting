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
				String sql = "select meeting.meetingid,bookpeople,topic,meetingroomname,starttime,endtime,meeting.explain from meetinguser inner join meeting on meetinguser.meetingid=meeting.meetingid where meetinguser.account='"
						+ useraccount + "'";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet set = pStatement.executeQuery(sql);
				while (set.next() == true) {
					Meeting meeting = new Meeting();
					meeting.setId(set.getInt(1));
					meeting.setBookpeople(set.getString(2));
					meeting.setTopic(set.getString(3));
					meeting.setRoomName(set.getString(4));
					meeting.setStarttime(set.getTimestamp(5));
					meeting.setEndtime(set.getTimestamp(6));
					meeting.setDetail(set.getString(7));
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

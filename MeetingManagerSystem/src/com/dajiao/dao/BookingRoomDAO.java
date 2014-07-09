package com.dajiao.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dajiao.model.Meeting;
import com.dajiao.model.MeetingRoom;
import com.dajiao.util.ConnectionFactory;

public class BookingRoomDAO {

	public BookingRoomDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<MeetingRoom> getMeetingRoom(Timestamp starttime, Timestamp endtime){
		System.out.println(starttime + "  " + endtime);
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		PreparedStatement pSt = null;
		Connection conn = ConnectionFactory.getConnection();
		if (conn == null)
			return null;
		try {
			String sql = "select meetingroomid,name,type from meetingroom where meetingroomid not in( select meetingroomid from meeting where (starttime > '"
					+ starttime
					+ "' and starttime < '"
					+ endtime
					+ "')or (endtime > '"
					+ starttime
					+ "' and endtime < '"
					+ endtime
					+ "')or (starttime <'"
					+ starttime
					+ "' and endtime >'" + endtime + "'))";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);
			while (rs.next() == true) {
				MeetingRoom room = new MeetingRoom();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setType(rs.getString(3));
				list.add(room);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean bookingRoom(Meeting meeting) {
		Connection conn = ConnectionFactory.getConnection();
		if (conn == null)
			return false;
		try {
			String sql = "insert into meeting(meetingroomid,topic,starttime,endtime,bookpeople) values("
					+ meeting.getMeetingRoom()
					+ ",'"
					+ meeting.getTopic()
					+ "','"
					+ meeting.getStarttime()
					+ "','"
					+ meeting.getEndtime()
					+ "','"
					+ meeting.getBookpeople()
					+ "');";
			PreparedStatement ps = conn.prepareStatement(sql);
			int rs = ps.executeUpdate(sql);
			if (rs == 0)
				return false;
			sql = "select meetingid from meeting where meetingroomid="
					+ meeting.getMeetingRoom() + " and topic='"
					+ meeting.getTopic() + "' and starttime='"
					+ meeting.getStarttime() + "' and endtime='"
					+ meeting.getEndtime() + "' and bookpeople='"
					+ meeting.getBookpeople() + "'";
			ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery(sql);
			int meetingid = 0;
			if (set.next() == true) {
				meetingid = set.getInt(1);
			}

			sql = "insert into notification(meetingid)values(" + meetingid
					+ ")";
			ps = conn.prepareStatement(sql);
			rs = ps.executeUpdate(sql);
			if (rs == 0)
				return false;
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

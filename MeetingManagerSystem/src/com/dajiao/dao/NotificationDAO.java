package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.Meeting;
import com.dajiao.model.MeetingRecord;
import com.dajiao.model.Notification;
import com.dajiao.util.ConnectionFactory;

public class NotificationDAO {

	public NotificationDAO() {
		// TODO Auto-generated constructor stub
	}

	// invite message
	public static List<Notification> getInviteList(String useraccount){


		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select meeting.topic,meetingroom.name,meeting.starttime,meeting.endtime,notification.detail from meeting inner join meetinguser on meetinguser.meetingid=meeting.meetingid inner join meetingroom on meetingroom.meetingroomid=meeting.meetingroomid inner join notification on notification.meetingid=meeting.meetingid where meetinguser.useraccount='"
					+ useraccount + "' and notification.type='invite'";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				Notification notify = new Notification();

				notify.setTopic(rs.getString(1));
				notify.setMeetingRoom(rs.getString(2));
				notify.setStarttime(rs.getTimestamp(3));
				notify.setEndtime(rs.getTimestamp(4));
				notify.setDetail(rs.getString(5));

				System.out.println("add invite notify:" + notify.getTopic());
				list.add(notify);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Notification> getChangeInfoList(String useraccount){
		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select meeting.topic,meetingroom.name,meeting.starttime,meeting.endtime,notification.detail from meeting inner join meetinguser on meetinguser.meetingid=meeting.meetingid inner join meetingroom on meetingroom.meetingroomid=meeting.meetingroomid inner join notification on notification.meetingid=meeting.meetingid where meetinguser.useraccount='"
					+ useraccount + "' and notification.type='change'";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				Notification notify = new Notification();

				notify.setTopic(rs.getString(1));
				notify.setMeetingRoom(rs.getString(2));
				notify.setStarttime(rs.getTimestamp(3));
				notify.setEndtime(rs.getTimestamp(4));
				notify.setDetail(rs.getString(5));

				System.out.println("add invite notify:" + notify.getTopic());
				list.add(notify);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<MeetingRecord> getRecordList(String useraccount){
		List<MeetingRecord> list = new ArrayList<MeetingRecord>();

		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select meeting.topic,summary.detail,summary.username from meeting  inner join meetinguser on meeting.meetingid=meetinguser.meetingid inner join summary on summary.meetingid=meeting.meetingid where meetinguser.useraccount='"
					+ useraccount + "' ";

			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				MeetingRecord record = new MeetingRecord();
				record.setTopic(rs.getString(1));
				record.setName(rs.getString(3));
				record.setDetail(rs.getString(2));

				System.out.println("add record:" + record.getDetail());
				list.add(record);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static boolean modifyMessage(Meeting meeting) {
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return false;
		try {
			PreparedStatement pSt = null;
			String sql = "insert into notification(meetingid,detail,type) values("
					+ meeting.getId()
					+ ",'"
					+ meeting.getDetail()
					+ "','change')";

			pSt = conn.prepareStatement(sql);
			int rs = pSt.executeUpdate(sql);

			if (rs == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}

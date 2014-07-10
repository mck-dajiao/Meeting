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

	public static List<MeetingRecord> getRecordList(String useraccount) {
		List<MeetingRecord> list = new ArrayList<MeetingRecord>();

		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select topic,bookpeople,summary.detail from meeting inner join summary on summary.meetingid=meeting.meetingid inner join meetinguser on meetinguser.meetingid=meeting.meetingid where meetinguser.account='"
					+ useraccount + "'";

			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				MeetingRecord record = new MeetingRecord();
				record.setTopic(rs.getString(1));
				record.setName(rs.getString(2));
				record.setDetail(rs.getString(3));

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
	
	public static List<Notification> getInviteList(String useraccount) {

		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select topic,meetingroomname,starttime,endtime,meeting.explain,meeting.meetingid from meeting inner join invite on invite.meetingid=meeting.meetingid where invite.account='"
					+ useraccount + "'";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				Notification notify = new Notification();

				notify.setTopic(rs.getString(1));
				notify.setMeetingRoom(rs.getString(2));
				notify.setStarttime(rs.getTimestamp(3));
				notify.setEndtime(rs.getTimestamp(4));
				notify.setDetail(rs.getString(5));
				notify.setId(rs.getInt(6));

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

	public static List<Notification> getChangeInfoList(String useraccount) {
		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select meeting.meetingid,topic,meetingroomname,starttime,endtime,meeting.change from meeting inner join meetinguser on meetinguser.meetingid=meeting.meetingid where meetinguser.account='"
					+ useraccount + "' and meeting.change is not null";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				Notification notify = new Notification();

				notify.setId(rs.getInt(1));
				notify.setTopic(rs.getString(2));
				notify.setMeetingRoom(rs.getString(3));
				notify.setStarttime(rs.getTimestamp(4));
				notify.setEndtime(rs.getTimestamp(5));
				notify.setDetail(rs.getString(6));

				System.out.println("add change notify:" + notify.getTopic());
				list.add(notify);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean agreeInvite(int meetingId, String account) {
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return false;
		try {
			PreparedStatement pSt = null;
			String sql = "insert into meetinguser(meetingid,account) values("
					+ meetingId + ",'" + account + "')";

			pSt = conn.prepareStatement(sql);
			int rs = pSt.executeUpdate(sql);
			if (rs == 0)
				return false;
			sql = "delete from invite where meetingid=" + meetingId
					+ " and account='" + account + "'";
			pSt = conn.prepareStatement(sql);
			rs = pSt.executeUpdate(sql);
			if (rs == 0)
				return false;
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean disagreeInvite(int meetingId, String account) {
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return false;
		try {
			PreparedStatement pSt = null;
			String sql = "delete from invite where meetingid=" + meetingId
					+ " and account='" + account + "'";

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

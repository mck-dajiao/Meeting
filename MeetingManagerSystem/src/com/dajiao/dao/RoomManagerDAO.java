package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.MeetingRoom;
import com.dajiao.util.ConnectionFactory;

public class RoomManagerDAO {

	public RoomManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<MeetingRoom> getALlMeetingRoom(){
				List<MeetingRoom> list = new ArrayList<MeetingRoom>();
				Connection connection = ConnectionFactory.getConnection();
				if (connection == null)
					return null;
				try {
					String sql = "select * from meetingroom " ;
					PreparedStatement pStatement = connection.prepareStatement(sql);
					ResultSet set = pStatement.executeQuery(sql);
					while (set.next() == true) {
						MeetingRoom meetingRoom = new MeetingRoom();
						meetingRoom.setId(set.getInt(1));
						meetingRoom.setNum(set.getInt(2));
						meetingRoom.setName(set.getString(3));
						meetingRoom.setType(set.getString(4));
						meetingRoom.setTotal(set.getInt(5));
						meetingRoom.setStatus(set.getString(6));
						list.add(meetingRoom);
					}
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}
	
		
	public static List<MeetingRoom> getMeetingRoomsByStatus(String status) {
		// 根据会议室状态获取会议室列表
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select * from meetingroom where status='" + status
					+ "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setId(set.getInt(1));
				meetingRoom.setNum(set.getInt(2));
				meetingRoom.setName(set.getString(3));
				meetingRoom.setType(set.getString(4));
				meetingRoom.setTotal(set.getInt(5));
				meetingRoom.setStatus(set.getString(6));
				list.add(meetingRoom);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static MeetingRoom getMeetingRoomById(int id) {
		// 根据会议室id获取会议室
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select * from meetingroom where meetingroomid='" + id
					+ "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			if (set.next() == true) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setId(set.getInt(1));
				meetingRoom.setNum(set.getInt(2));
				meetingRoom.setName(set.getString(3));
				meetingRoom.setType(set.getString(4));
				meetingRoom.setTotal(set.getInt(5));
				meetingRoom.setStatus(set.getString(6));
				return meetingRoom;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<MeetingRoom> getMeetingRoomLt(int num) {
		// 返回容纳数量少于num的会议室
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select * from meetingroom where total<'" + num + "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setId(set.getInt(1));
				meetingRoom.setNum(set.getInt(2));
				meetingRoom.setName(set.getString(3));
				meetingRoom.setType(set.getString(4));
				meetingRoom.setTotal(set.getInt(5));
				meetingRoom.setStatus(set.getString(6));
				list.add(meetingRoom);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<MeetingRoom> getMeetingRoomMt(int num) {
		// 返回可容纳数量大于num的会议室
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return null;
		try {
			String sql = "select * from meetingroom where total>'" + num + "'";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet set = pStatement.executeQuery(sql);
			while (set.next() == true) {
				MeetingRoom meetingRoom = new MeetingRoom();
				meetingRoom.setId(set.getInt(1));
				meetingRoom.setNum(set.getInt(2));
				meetingRoom.setName(set.getString(3));
				meetingRoom.setType(set.getString(4));
				meetingRoom.setTotal(set.getInt(5));
				meetingRoom.setStatus(set.getString(6));
				list.add(meetingRoom);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean modifyMeetingRoom(MeetingRoom meetingroom) {
		// 修改会议室信息
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "update meetingroom set meetingroomid="
					+ meetingroom.getId() + ",num=" + meetingroom.getNum()
					+ ",name='" + meetingroom.getName() + "',type='"
					+ meetingroom.getType() + "',total="
					+ meetingroom.getTotal() + ",status='"
					+ meetingroom.getStatus() + "' where meetingroomid="
					+ meetingroom.getId() + "";
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

	public static boolean closeMeetingRoom(int id) {
		// 暂时关闭会议室
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "update meetingroom set status='close' where meetingroomid="
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

	public static boolean openMeetingRoom(int id) {
		// 启用会议室
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = "update meetingroom set status='open' where meetingroomid="
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

	public static boolean deleteMeetingRoom(String[] roomId) {
		Connection connection = ConnectionFactory.getConnection();
		if (connection == null)
			return false;
		try {
			String sql = null;
			int set = 1;
			for (int i = 0; i < roomId.length; i++) {
				sql = "delete from meetingroom where meetingroomid="
						+ roomId[i] + "";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				set = pStatement.executeUpdate(sql) ^ set;
			}
			if (set == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}

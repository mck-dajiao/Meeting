package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.util.ConnectionFactory;

public class SelectMeetingroomDAO {
public List looking(){
	List list=new ArrayList();
	Connection conn=ConnectionFactory.getConnection();
	String sql="select roomcode,roomname,capacity,status from  meetingroom";
	try {
		Statement  stmt = conn.createStatement();
		
		ResultSet rs =stmt.executeQuery(sql);
		while(rs.next()){
			
			Integer roomcode=rs.getInt("roomcode");
			String roomname=rs.getString("roomname");
			Integer capacity=rs.getInt("capacity");
			String status=rs.getString("status");
			MeetingRoom MR=new MeetingRoom(roomcode,roomname,capacity,status);
			MR.setRoomcode(roomcode);
			MR.setRoomname(roomname);
			MR.setCapacity(capacity);
			MR.setStatus(status);
			list.add(MR);
			System.out.println(roomcode);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
	public MeetingRoom roomDetail(String meetid){
 		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from meetingroom where roomcode=?";
		ResultSet rs = null;
		MeetingRoom mtroom = new MeetingRoom();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(meetid));
			rs = pstmt.executeQuery();
			if(rs.next()){
				mtroom.setRoomid(rs.getInt("roomid"));
				mtroom.setRoomcode(rs.getInt("roomcode"));
				mtroom.setRoomname(rs.getString("roomname"));
				mtroom.setCapacity(rs.getInt("capacity"));
				mtroom.setStatus(rs.getString("status"));
				mtroom.setDescription(rs.getString("description"));
			}
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mtroom;
		
	}
	
	public int updateRoom(MeetingRoom mtroom ){
		int updateFlag = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update meetingroom set roomcode=?," +
				"roomname=?,capacity=?,status=?,description=?" +
				"where roomid=?";
		
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, mtroom.getRoomcode());
			pstmt.setString(2,mtroom.getRoomname() );
			pstmt.setInt(3, mtroom.getCapacity());
			pstmt.setString(4, mtroom.getStatus());
			pstmt.setString(5, mtroom.getDescription());
			pstmt.setInt(6, mtroom.getRoomid());
			updateFlag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateFlag;
	}
	
	
	public static void main(String[] args) {
		new SelectMeetingroomDAO().roomDetail("101");
	}

}

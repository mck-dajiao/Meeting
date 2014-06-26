package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.util.ConnectionFactory;

public class MeetingRoomDao {
	public int insert(MeetingRoom mr){
		int insFlg = 0;
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "insert into Meetingroom " +
				"(roomcode,roomname,capacity,status,description)" +
				" values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,mr.getRoomcode() );
				pstmt.setString(2, mr.getRoomname());
				pstmt.setInt(3,mr.getCapacity() );
				pstmt.setString(4,mr.getStatus());
				pstmt.setString(5,mr.getDescription() );
 				//÷¥––≤Â»Î”Ôæ‰
				insFlg = pstmt.executeUpdate();
				if(insFlg != 0){
					System.out.println("insert Success!");
				}else{
					System.out.println("Fail!");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return insFlg;
	}
	public List<MeetingRoom> findmtRoom() {
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from meetingroom order by roomid";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MeetingRoom mr = new MeetingRoom();
				mr.setRoomid(rs.getInt("roomid"));
				mr.setRoomname(rs.getString("roomname"));
				list.add(mr);
			}
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

//	public static void main(String[] args) {
//		new MeetingRoomDao().findmtRoom();
//	}
}

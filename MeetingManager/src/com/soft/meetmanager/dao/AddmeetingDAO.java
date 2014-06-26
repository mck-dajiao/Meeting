package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.util.ConnectionFactory;

public class AddmeetingDAO {
	
	//添加
	public int insert(Meeting mt){
		int insFlg = 0;
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "insert into Meeting " +
				"(meetingname,NUMBEROFPARTICIPANTS,starttime,endtime,description,peoplename,reservationistid,reservationtime)" +
				" values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,mt.getMeetingname() );
				pstmt.setInt(2, mt.getNumberofparticipants());
				pstmt.setDate(3,mt.getStarttime() );
				pstmt.setDate(4,mt.getEndtime() );
				pstmt.setString(5,mt.getDescription() );
				pstmt.setString(6, mt.getPeoplename());
				pstmt.setInt(7, mt.getReservationisid());
				pstmt.setDate(8, mt.getReservationtime());
 				//执行插入语句
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
	//预约会议
	public int bookMeetRoom(Meeting mt){
		int bookFlag = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from meeting where starttime>? and endtime<? and roomid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, mt.getEndtime());
			pstmt.setDate(2, mt.getStarttime());
			pstmt.setInt(3, mt.getRoomid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				bookFlag = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookFlag;
	}
	public static void main(String[] args) {
		new AddmeetingDAO().insert(null);
	}
}

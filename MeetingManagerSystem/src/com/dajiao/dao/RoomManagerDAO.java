package com.dajiao.dao;

import java.util.List;

import com.dajiao.model.MeetingRoom;

public class RoomManagerDAO {

	public RoomManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<MeetingRoom> getALlMeetingRoom(){
		return null;
	}
	
	public static List<MeetingRoom> getMeetingRoomsByStatus(String status){
		// 根据会议室状态获取会议室列表
		return null;
	}
	
	public static MeetingRoom getMeetingRoomById(int id){
		// 根据会议室id获取会议室
		return null;
	}

	public static List<MeetingRoom> getMeetingRoomLt(int num){
		// 返回容纳数量少于num的会议室
		return null;
	}
	
	public static List<MeetingRoom> getMeetingRoomMt(int num){
		// 返回可容纳数量大于num的会议室
		return null;
	}
	
	public static boolean modifyMeetingRoom(MeetingRoom meetingroom){
		// 修改会议室信息
		return false;
	}
	
	public static boolean closeMeetingRoom(int id){
		// 暂时关闭会议室
		return false;
	}
	
	public static boolean openMeetingRoom(int id){
		// 启用会议室
		return false;
	}
	
	public static boolean deleteMeetingRoom(String[] roomId){
		return false;
	}
}

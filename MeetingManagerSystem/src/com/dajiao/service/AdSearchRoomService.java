package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.RoomManagerDAO;
import com.dajiao.model.MeetingRoom;

public class AdSearchRoomService {

	public AdSearchRoomService() {
		// TODO Auto-generated constructor stub
	}

	public static List<MeetingRoom> getRoomList(){
		return RoomManagerDAO.getALlMeetingRoom();
	}
	
	public static List<MeetingRoom> getRoomListByStatus(String status){
		return RoomManagerDAO.getMeetingRoomsByStatus(status);
	}
	
	public static boolean modifyRoom(MeetingRoom meetingRoom){
		return RoomManagerDAO.modifyMeetingRoom(meetingRoom);
	}
	
	public static boolean deleteRoom(String[] roomId){
		return RoomManagerDAO.deleteMeetingRoom(roomId);
	}
	
}

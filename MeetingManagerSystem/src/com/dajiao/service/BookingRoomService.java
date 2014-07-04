package com.dajiao.service;

import java.sql.Timestamp;
import java.util.List;

import com.dajiao.dao.BookingRoomDAO;
import com.dajiao.model.MeetingRoom;

public class BookingRoomService {

	public BookingRoomService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<MeetingRoom> getRoomList(Timestamp startTime, Timestamp endTime){
		return BookingRoomDAO.getMeetingRoom(startTime, endTime);
	}

}

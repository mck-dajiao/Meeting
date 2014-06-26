package com.soft.meetmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.dao.MeetingRoomDao;
import com.soft.meetmanager.dao.SelectMeetingroomDAO;
import com.soft.meetmanager.model.MeetingRoom;

public class MeetingRoomService {
	public MeetingRoomDao mtdao = new MeetingRoomDao();
	public SelectMeetingroomDAO mtseldao = new SelectMeetingroomDAO();
	
	public void insert(MeetingRoom mr){
		mtdao.insert(mr);
	}
	public List<MeetingRoom> findmetRoom(){
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		list = mtdao.findmtRoom();		
		return list;
	}
	//查看所有的会议室
	public List<MeetingRoom> findRoom(){
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		list = mtseldao.looking();	
		return list;
	}
	//查看会议室详情
	public MeetingRoom roomDetail(String meetid){
		MeetingRoom mtroom = new MeetingRoom();
		mtroom = mtseldao.roomDetail(meetid);
		return mtroom;
	}
	//修改会议室信息
	public int updateRoom(MeetingRoom mtroom ){
		int updateFlag = 0;
		updateFlag = mtseldao.updateRoom(mtroom);
		return updateFlag;
	}
}

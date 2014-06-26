package com.soft.meetmanager.service;


import com.soft.meetmanager.dao.AdddepartmentDAO;
import com.soft.meetmanager.dao.MeetingRoomDao;
import com.soft.meetmanager.model.Department;
import com.soft.meetmanager.model.MeetingRoom;

public class AdddepartmentService {
	public  void addd(Department  dtp){
		AdddepartmentDAO adp=new AdddepartmentDAO();
		adp.insert(dtp);
	}
	
}

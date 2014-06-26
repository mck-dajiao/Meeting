package com.soft.meetmanager.service;

import com.soft.meetmanager.dao.AddmeetingDAO;
import com.soft.meetmanager.model.Meeting;

public class AddmeetingService {

	AddmeetingDAO addao = new AddmeetingDAO();
	public int addmeetig(Meeting metdel){
		int insFlag = 0;
		insFlag = addao.insert(metdel);
		return insFlag;
	}
	
	//预约会议之前首先查询一遍会议室是否被占用
	public int bookMeetingRoom(Meeting mt){
		int flag = 0;
		flag = addao.bookMeetRoom(mt);
		//如果flag等于1，说明会议室已被使用
		if(flag != 1){
			System.out.println("会议室已被使用！");
			flag =3 ;
		}else{
			flag = addao.insert(mt);
 		}
		return flag;
	}
}

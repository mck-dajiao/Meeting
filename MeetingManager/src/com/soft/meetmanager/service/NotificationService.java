package com.soft.meetmanager.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.soft.meetmanager.dao.NotificationDAO;
import com.soft.meetmanager.model.Meeting;

public class NotificationService {
	NotificationDAO  mydao = new NotificationDAO();
	public List<Meeting> selectMymeet(int userid){
		String nowdate = this.getNow();
		String nextdate = this.getNextTime(7);
		List<Meeting> list = new ArrayList<Meeting>();
		list = mydao.selectMyfuturemeet(userid,nowdate,nextdate);
		return list;
	}
	
	//获取当前时间
	public String getNow(){
		String now = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		String timeTmp = sf.format(dt);
		String[] timeArry = timeTmp.split("-");
		now = timeArry[0]+timeArry[1]+timeArry[2];
		return now;
 	}
	//获取七天后的时间
	public String getNextTime(int day){  
		   Calendar now =Calendar.getInstance(); 
		   Date dt = new Date();
		  now.setTime(dt);  
		   now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
		   SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		   String strTmp = sf.format(now.getTime());
		   String[] strArry = strTmp.split("-");
		   String nexttime = strArry[0]+strArry[1]+strArry[2];
		   return nexttime;  
		
	}
	
}

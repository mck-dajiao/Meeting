package com.soft.meetmanager.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		System.out.println(sf.format(now));
		getDateAfter(now, 7);
		System.out.println(10/2+"........................1?");
	}
	public static Date getDateAfter(Date d,int day){  
		   Calendar now =Calendar.getInstance();  
		  now.setTime(d);  
		   now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
 		   SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
 		   return now.getTime();  
		  }  

}

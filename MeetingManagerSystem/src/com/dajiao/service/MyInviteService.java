package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.EmployeeManagerDAO;
import com.dajiao.dao.MyInviteDAO;
import com.dajiao.model.User;

public class MyInviteService {

	public MyInviteService() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<User> getInviteList(int meetingId){
		return MyInviteDAO.getInviteList(meetingId);
	}
	
	public static List<User> getUserList(String name, String department){
		
		if(name != null && name != ""){
			System.out.println("search name ");
			return EmployeeManagerDAO.getUserByName(name);
		}
		
		if(department != null && department != ""){
			System.out.println("search department");
			return EmployeeManagerDAO.getUserByDepartmentName(department);
		}
		
		System.out.println(" enter get all user ");
		return EmployeeManagerDAO.getAllUser();
		
//		if(name == null && sex == null && department == null){
//			return EmployeeManagerDAO.getAllUser();
//		}else{
//			List<User> list1 = EmployeeManagerDAO.getUserByName(name);
//			
//			List<User> list2 = EmployeeManagerDAO.getUserBySex(sex);
//			
//			List<User> list3 = EmployeeManagerDAO.getUserByDepartmentName(department);
//
//			if(list1.isEmpty() == true){
//				for(User user : list2)
//					if(list3.contains(user) == false)
//					list3.add(user);
//				
//				return list3;
//			}
//			
//			if(list2.isEmpty() == true){
//				for(User user : list1)
//					if(list3.contains(user) == false)
//					list3.add(user);
//				
//				return list3;
//			}
//			
//			if(list3.isEmpty() == true){
//				for(User user : list1)
//					if(list2.contains(user) == false)
//					list2.add(user);
//				
//				return list2;
//			}
//			
//			list1.addAll(list2);
//			for(User user : list1)
//				if(list3.contains(user) == false)
//				list3.add(user);
//			
//			return list3;
//		}
		
	}

	public static boolean deleteUser(String account, int meetingId){
		return MyInviteDAO.deleteInvite(account, meetingId);
	}
	public static boolean inviteUser(String[] account , int meetingId){
		return MyInviteDAO.inviteUser(account, meetingId);
	}
}

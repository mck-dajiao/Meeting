package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.EquitmentManagerDAO;
import com.dajiao.model.Borrow;

public class AdEquitmentService {

	public AdEquitmentService() {
		// TODO Auto-generated constructor stub
	}

	public static boolean changeStatus(String id){
		int borrowId;
		try{
			borrowId = Integer.parseInt(id);
			Borrow borrow = EquitmentManagerDAO.getBorrowById(borrowId);
			if(borrow.getStatus().equals("borrowing")){
				return EquitmentManagerDAO.approval(borrowId);
			}else if(borrow.getStatus().equals("borrowed")){
				return EquitmentManagerDAO.giveBack(borrowId);
			}
		}catch(Exception e){
			System.out.println("can't parse id");
		}
		
		return false;
	}
	
	public static List<Borrow> getBorrowList(){
		return EquitmentManagerDAO.getBorrowList();
	}
}

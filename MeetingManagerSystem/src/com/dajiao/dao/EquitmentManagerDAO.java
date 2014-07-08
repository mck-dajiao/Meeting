package com.dajiao.dao;

import java.util.List;

import com.dajiao.model.Borrow;

public class EquitmentManagerDAO {

	public EquitmentManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Borrow> getBorrowList(){
		// 获取借用表，未归还的和未批准的
		return null;
	}

	public static boolean approval(int id){
		// 同意借出
		return false;
	}
	
	public static boolean giveBack(int id){
		// 归还
		return false;
	}
	
	public static Borrow getBorrowById(int id){
		return null;
	}
}

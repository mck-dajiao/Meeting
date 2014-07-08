package com.dajiao.model;

import java.sql.Timestamp;

public class Borrow {
	
	private int id;
	private int meetingId;
	private String borrower;
	private Timestamp date;
	private String status;
	private int aNum;
	private int bNum;
	private int cNum;

	public Borrow() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the meetingId
	 */
	public int getMeetingId() {
		return meetingId;
	}

	/**
	 * @param meetingId the meetingId to set
	 */
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	/**
	 * @return the borrower
	 */
	public String getBorrower() {
		return borrower;
	}

	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * @return the aNum
	 */
	public int getaNum() {
		return aNum;
	}

	/**
	 * @param aNum the aNum to set
	 */
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}

	/**
	 * @return the bNum
	 */
	public int getbNum() {
		return bNum;
	}

	/**
	 * @param bNum the bNum to set
	 */
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	/**
	 * @return the cNum
	 */
	public int getcNum() {
		return cNum;
	}

	/**
	 * @param cNum the cNum to set
	 */
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

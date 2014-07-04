package com.dajiao.model;

import java.sql.Timestamp;

public class Meeting {
	
	private int id;
	private String bookpeople;
	private String topic;
	private int meetingRoom;
	private String roomName;
	private Timestamp starttime;
	private Timestamp endtime;
	private String detail;
	

	public Meeting() {
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
	 * @return the bookpeople
	 */
	public String getbookpeople() {
		return bookpeople;
	}


	/**
	 * @param bookpeople the bookpeople to set
	 */
	public void setbookpeople(String bookpeople) {
		this.bookpeople = bookpeople;
	}


	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}


	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}


	/**
	 * @return the meetingRoom
	 */
	public int getMeetingRoom() {
		return meetingRoom;
	}


	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(int meetingRoom) {
		this.meetingRoom = meetingRoom;
	}


	/**
	 * @return the starttime
	 */
	public Timestamp getStarttime() {
		return starttime;
	}


	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}


	/**
	 * @return the endtime
	 */
	public Timestamp getEndtime() {
		return endtime;
	}


	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}


	/**
	 * @return the bookpeople
	 */
	public String getBookpeople() {
		return bookpeople;
	}


	/**
	 * @param bookpeople the bookpeople to set
	 */
	public void setBookpeople(String bookpeople) {
		this.bookpeople = bookpeople;
	}


	/**
	 * @return the roomName
	 */
	public String getRoomname() {
		return roomName;
	}


	/**
	 * @param roomname the roomName to set
	 */
	public void setRoomname(String roomName) {
		this.roomName = roomName;
	}


	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}


	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}


	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
}

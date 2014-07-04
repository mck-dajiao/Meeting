package com.dajiao.model;

import java.sql.Timestamp;

public class Meeting {
	
	private int id;
	private String bookpeople;
	private String topic;
	private int meetingRoom;
	private Timestamp strattime;
	private Timestamp endtime;
	

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
	 * @return the strattime
	 */
	public Timestamp getStrattime() {
		return strattime;
	}


	/**
	 * @param strattime the strattime to set
	 */
	public void setStrattime(Timestamp strattime) {
		this.strattime = strattime;
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


}

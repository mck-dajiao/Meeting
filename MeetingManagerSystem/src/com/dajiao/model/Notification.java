package com.dajiao.model;

import java.sql.Timestamp;

public class Notification {
	
	private int id;
	private Timestamp starttime;
	private Timestamp endtime;
	private String useraccount;
	private String topic;
	private String meetingRoom;
	private String detail;
	private String type;

	public Notification() {
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
	public String getMeetingRoom() {
		return meetingRoom;
	}

	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the useraccount
	 */
	public String getUseraccount() {
		return useraccount;
	}

	/**
	 * @param useraccount the useraccount to set
	 */
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
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

	
	

}

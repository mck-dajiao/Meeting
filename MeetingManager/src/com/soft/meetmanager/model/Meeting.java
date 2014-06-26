package com.soft.meetmanager.model;

import java.sql.Date;

public class Meeting {
	
	private Integer meetingid;
	private Integer roomid;
	private Integer reservationisid;
	private Integer numberofparticipants;
	private Date starttime;
	private Date endtime;
	private Date  reservationtime;
	private Date  canceledtime;
	private String meetingname;
	private String status;
	private String description;
	private String peoplename;
	private String roomname;
	public Meeting(){
		
	}
	public String getPeoplename() {
		return peoplename;
	}
	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}
	public Meeting(String meetingname,Integer roomid,Integer numberofparticipants,
			Date starttime,Date endtime,String description,String peoplename,
			Integer reservationisid,Date  reservationtime){
		this.meetingname=meetingname;
		this.numberofparticipants=numberofparticipants;
		this.starttime=starttime;
		this.endtime=endtime;
		this.description=description;
		this.peoplename=peoplename;
		this.roomid = roomid;
		this.reservationisid = reservationisid;
		this.reservationtime = reservationtime;
	}
	public Integer getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	public Integer getReservationisid() {
		return reservationisid;
	}
	public void setReservationisid(Integer reservationisid) {
		this.reservationisid = reservationisid;
	}
	public Integer getNumberofparticipants() {
		return numberofparticipants;
	}
	public void setNumberofparticipants(Integer numberofparticipants) {
		this.numberofparticipants = numberofparticipants;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Date getReservationtime() {
		return reservationtime;
	}
	public void setReservationtime(Date reservationtime) {
		this.reservationtime = reservationtime;
	}
	public Date getCanceledtime() {
		return canceledtime;
	}
	public void setCanceledtime(Date canceledtime) {
		this.canceledtime = canceledtime;
	}
	public String getMeetingname() {
		return meetingname;
	}
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	
	
}

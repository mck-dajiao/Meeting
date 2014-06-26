package com.soft.meetmanager.model;

public class MeetingRoom {
	  private Integer roomid;
	  private Integer roomcode;
	  private Integer capacity;
	  private String roomname;
	  private String  status;
	  private String description;
	  //roomnumber capacity roomcapacity  status description
	  public MeetingRoom(Integer roomnumber,String capacity,Integer roomcapacity ,String status,String description){
		  this.roomcode=roomnumber;
		  this.capacity=roomcapacity;
		  this.roomname=capacity;
		  this.status=status;
		  this.description=description;
	  }
	  public MeetingRoom(Integer roomnumber,String capacity,Integer roomcapacity ,String status){
		  this.roomcode=roomnumber;
		  this.capacity=roomcapacity;
		  this.roomname=capacity;
		  this.status=status;
		
	  }
	  public MeetingRoom(){
		  
	  }
	public Integer getRoomid() {
		return roomid;
	}
	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}
	public Integer getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(Integer roomcode) {
		this.roomcode = roomcode;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
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
	  
}

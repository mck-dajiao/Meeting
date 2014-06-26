package com.soft.meetmanager.model;

public class Department {
	 private Integer departmentid;
	  private String departmentname;
	  public Department(){
		  
	  }
	  public Department(Integer departmentid ,String departmentname){
		  this.departmentid=departmentid;
		  this.departmentname=departmentname;
	  }
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	  
}

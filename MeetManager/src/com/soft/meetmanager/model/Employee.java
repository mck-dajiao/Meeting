package com.soft.meetmanager.model;

public class Employee {
  private Integer employeeid;
  private String phone;
  private Integer departmentid;
  private String employeename;
  private String username;
  private String email;
  private String status;
  private String password;
  private String role;
  public Employee(){
	  
  }
  public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Employee(String username,String password){
	this.username=username;
	this.password=password;
}

//employeename accountname password phone email
  public Employee(String employeename,String accountname, String password,String phone, String email,Integer departmentid){
	  this.employeename=employeename;
	  this.username=accountname;
	  this.phone=phone;
	  this.email=email;
	  this.password=password;
	  this.departmentid=departmentid;
  }
public Integer getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(Integer employeeid) {
	this.employeeid = employeeid;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Integer getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(Integer departmentid) {
	this.departmentid = departmentid;
}
public String getEmployeename() {
	return employeename;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUserName() {
	// TODO Auto-generated method stub
	return null;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
  
  
}

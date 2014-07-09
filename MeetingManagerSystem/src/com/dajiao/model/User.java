package com.dajiao.model;

public class User extends Person {
	
	private String userid;
	private String name;
	private String sex;
	private String anhao;
	private String department;
	private String status;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String account) {
		super(account);
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String department, String status){
		this.name = name;
		this.department = department;
		this.status = status;
	}
	
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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

	/**
	 * @return the anhao
	 */
	public String getAnhao() {
		return anhao;
	}

	/**
	 * @param anhao the anhao to set
	 */
	public void setAnhao(String anhao) {
		this.anhao = anhao;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}

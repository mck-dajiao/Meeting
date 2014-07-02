package com.dajiao.model;

public class User extends Person {
	
	private String id;
	private String account;
	private String name;
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
	
	public User(String account, String name, String department, String status){
		this.account = account;
		this.name = name;
		this.department = department;
		this.status = status;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the account
	 */
	public String getaccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setaccount(String account) {
		this.account = account;
	}

	/**
	 * @return the name
	 */
	public String getname() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setname(String name) {
		this.name = name;
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
	
	
}

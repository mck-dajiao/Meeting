package com.dajiao.model;

public class Person {
	
	protected String account;
	
	public Person(){
	}
	
	public Person(String account){
		this.account = account;
	}

	/**
	 * @return the name
	 */
	public String getaccount() {
		return account;
	}

	/**
	 * @param name the name to set
	 */
	public void setaccount(String account) {
		this.account = account;
	}

}

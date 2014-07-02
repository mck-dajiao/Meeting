package com.dajiao.model;

public class Person {
	
	private String username;
	
	public Person(){
	}
	
	public Person(String username){
		this.username = username;
	}

	/**
	 * @return the name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param name the name to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}

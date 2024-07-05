package com.study.beans;

import java.io.Serializable;

public class UserBeans implements Serializable {
	
	private String username;
	private String email;
	private String userid;
	private String userpw;
	
	public UserBeans() {
		// TODO Auto-generated constructor stub
	}
	
	// Getter
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getUserid() {
		return userid;
	}
	public String getUserpw() {
		return userpw;
	}
	
	// Setter
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserEmail(String email) {
		this.email = email;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
}

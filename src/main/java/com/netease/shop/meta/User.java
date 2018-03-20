package com.netease.shop.meta;

import java.io.Serializable;

public class User implements Serializable {
	private int userId;
	private String username;
	private String password;
	private int usertype;//0买家,1卖家

	public User(){
		
	}
	
	public User(String username ,String password,int usertype){
		super();
		this.username=username;
		this.setPassword(password);
		this.usertype=usertype;
	}
	public User(int userId,String username ,String password,int usertype){
		super();
		this.userId=userId;
		this.username=username;
		this.setPassword(password);
		this.usertype=usertype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", usertype=" + usertype
				+ "]";
	}
	
	
}

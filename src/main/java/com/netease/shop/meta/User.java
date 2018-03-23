package com.netease.shop.meta;

import java.io.Serializable;
/**
 * 用户类
 */
public class User implements Serializable {
	private int id;
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
		this.id=userId;
		this.username=username;
		this.setPassword(password);
		this.usertype=usertype;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype
				+ "]";
	}
	
	
}

package com.netease.shop.meta;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String pwd;
	private int usertype;//1 卖家，2买家

	public User(){
		
	}
	public User(String username ,String pwd,int usertype){
		super();
		this.username=username;
		this.pwd=pwd;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
}

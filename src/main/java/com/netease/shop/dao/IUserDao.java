package com.netease.shop.dao;


import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import com.netease.shop.meta.User;

public interface IUserDao {
	@Results({ 
		@Result(property = "userId", column = "user_id"), 
		@Result(property = "username", column = "username"),
		@Result(property = "password", column = "password"),
		@Result(property = "usertype", column = "usertype")}
	)
	@Select("select * from tb_user where username=#{username}")
	public User getUser(String username);
}

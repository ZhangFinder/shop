package com.netease.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import com.netease.shop.meta.User;

/**
 * 用户信息相关操作,对应表tb_user
 */
public interface IUserDao {
	@Results({ @Result(property = "id", column = "user_id"), @Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"), @Result(property = "usertype", column = "usertype") })
	@Select("select * from tb_user where username=#{username}")
	public User getUser(@Param("username") String username);
}

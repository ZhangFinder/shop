package com.netease.shop.service;

import com.netease.shop.meta.User;

public interface IUserService {
	/**
	 * 检查用户名和密码是否正确
	 * 
	 * @param trades
	 * @return
	 */
    public User  checkUsernameAndPwd(String username,String password);
}

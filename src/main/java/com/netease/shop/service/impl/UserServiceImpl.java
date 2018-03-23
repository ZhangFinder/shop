package com.netease.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.shop.dao.IUserDao;
import com.netease.shop.meta.User;
import com.netease.shop.service.IUserService;

@Service("userServie")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public User checkUsernameAndPwd(String username, String password) {
		User user = userDao.getUser(username);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {

			return null;
		}

	}

}

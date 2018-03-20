package com.netease.shop.service;

import com.netease.shop.meta.User;

public interface IUserService {
    public User  checkUsernameAndPwd(String username,String password);
}

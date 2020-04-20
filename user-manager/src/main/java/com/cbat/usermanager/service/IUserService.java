package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.UserBean;

public interface IUserService {
    UserBean findUser(UserBean userBean);
    UserBean findByUserName(String userName);
    void addUser(UserBean userBean);
}

package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.UserToRoleBean;

public interface IUserToRoleService {
    void add(UserToRoleBean userToRoleBean);
    void del(UserToRoleBean userToRoleBean);
}

package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;

import java.util.List;

public interface IUserToRoleService {
    void add(UserToRoleBean userToRoleBean);
    void del(UserToRoleBean userToRoleBean);
    void addAll(List<UserToRoleBean> userToRoleBeans);
    List<UserToRoleBean> findByRoleId(String roleId);
}

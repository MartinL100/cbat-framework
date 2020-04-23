package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.UserBean;

import java.util.List;

public interface IUserService {
    UserBean findUser(UserBean userBean);
    UserBean findByUserName(String userName);
    void addUser(UserBean userBean);
    void del(String userId);
    List<UserBean>getUsersByRoleId(String roleId);
    List<UserBean> getUsersByPermissId(String permissionId);

}

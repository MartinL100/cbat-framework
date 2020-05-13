package com.cbat.usermanager.service.impl;


import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.dao.UserRepository;
import com.cbat.usermanager.service.IUserService;
import com.cbat.usermanager.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserBean findUser(UserBean userBean) {
        Assert.notEmpty(userBean.getPwd(),"密码不能为空");
        Assert.notEmpty(userBean.getUserName(),"用户名不能为空");
        UserBean user = userRepository.findByPwdAndUserName(
                userBean.getPwd(),userBean.getUserName()
        );
        return user;
    }

    @Override
    public UserBean findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void addUser(UserBean userBean) {
        Assert.notEmpty(userBean.getPwd(),"密码不能为空");
        Assert.notEmpty(userBean.getUserName(),"用户名不能为空");
        userBean.setPwd(MD5Util.MD5EncodeUtf8(userBean.getPwd()));
        userRepository.save(userBean);
    }

    @Override
    public void del(String  userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserBean> getUsersByRoleId(String roleId) {

        return userRepository.getUsersByRoleId(roleId);
    }

    @Override
    public List<UserBean> getUsersByPermissId(String permissionId) {
        return userRepository.getUsersByPermissionId(permissionId);
    }
}

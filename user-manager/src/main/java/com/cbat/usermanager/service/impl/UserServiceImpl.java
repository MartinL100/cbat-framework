package com.cbat.usermanager.service.impl;


import com.cbat.exceptionhandler.util.Assert;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.dao.UserRepository;
import com.cbat.usermanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserBean findUser(UserBean userBean) {
        Assert.notEmpty(userBean.getPwd(),"E00000003");
        Assert.notEmpty(userBean.getUserName(),"E00000004");
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
        Assert.notEmpty(userBean.getPwd(),"E00000003");
        Assert.notEmpty(userBean.getUserName(),"E00000004");
        userRepository.save(userBean);
    }
}

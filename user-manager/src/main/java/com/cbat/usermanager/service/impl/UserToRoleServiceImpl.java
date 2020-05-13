package com.cbat.usermanager.service.impl;



import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import com.cbat.usermanager.dao.UserToRoleRepository;
import com.cbat.usermanager.service.IUserToRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToRoleServiceImpl implements IUserToRoleService {
    @Autowired
    private UserToRoleRepository repository;
    @Override
    public void add(UserToRoleBean userToRoleBean) {
        Assert.notEmpty(userToRoleBean.getRoleId(),"角色编号不能为空");
        Assert.notEmpty(userToRoleBean.getUserId(),"用户编号不能为空");
        repository.save(userToRoleBean);
    }

    @Override
    public void del(UserToRoleBean userToRoleBean) {
        Assert.notEmpty(userToRoleBean.getRoleId(),"角色编号不能为空");
        Assert.notEmpty(userToRoleBean.getUserId(),"用户编号不能为空");
        repository.delete(userToRoleBean);
    }

    @Override
    public void addAll(List<UserToRoleBean> userToRoleBeans) {
        repository.saveAll(userToRoleBeans);
    }

    @Override
    public List<UserToRoleBean> findByRoleId(String roleId) {
        return repository.findByRoleId(roleId);
    }


}

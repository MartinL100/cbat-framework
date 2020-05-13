package com.cbat.usermanager.service.impl;


import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import com.cbat.usermanager.dao.RoleRepository;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IUserToRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    IUserToRoleService userToRoleService;
    @Override
    public List<RoleBean> findByUserId(String userId) {

        return roleRepository.getRoleBeans(userId);
    }

    @Override
    public void addRole(RoleBean roleBean) {
        roleRepository.save(roleBean);
    }

    @Override
    public void del(String roleId) {
        List<UserToRoleBean> userToRoles = userToRoleService.findByRoleId(roleId);
        Assert.notNull(userToRoles,"还有用户拥有该角色，不能删除该角色");
        roleRepository.deleteById(roleId);
    }
}

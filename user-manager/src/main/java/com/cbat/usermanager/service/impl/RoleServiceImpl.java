package com.cbat.usermanager.service.impl;


import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.dao.RoleRepository;
import com.cbat.usermanager.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<RoleBean> findByUserId(String userId) {

        return roleRepository.getRoleBeans(userId);
    }

    @Override
    public void addRole(RoleBean roleBean) {
        roleRepository.save(roleBean);
    }
}

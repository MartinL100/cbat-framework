package com.cbat.usermanager.service.impl;


import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.dao.PermissionRepository;
import com.cbat.usermanager.service.IPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisServiceImpl implements IPermisService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public List<PermissionBean> getPermises(String roleId) {
        return permissionRepository.getPermissionBeansByRoleId(roleId);
    }

    @Override
    public void addPermis(PermissionBean permissionBean) {
        permissionRepository.save(permissionBean);
    }

    @Override
    public List<PermissionBean> findAll() {
        return permissionRepository.findAll();
    }
}

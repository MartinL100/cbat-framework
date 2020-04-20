package com.cbat.usermanager.service.impl;


import com.cbat.exceptionhandler.util.Assert;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.dao.RoleToPermisRepository;
import com.cbat.usermanager.service.IRoleToPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleToPermisServiceImpl implements IRoleToPermisService {
    @Autowired
    private RoleToPermisRepository repository;
    @Override
    public void add(RoleToPermisBean roleToPermisBean) {
        Assert.notEmpty(roleToPermisBean.getRoleId(),"E00000001");
        Assert.notEmpty(roleToPermisBean.getPermissionId(),"E00000002");
        repository.save(roleToPermisBean);
    }

    @Override
    public void del(RoleToPermisBean roleToPermisBean) {
        Assert.notEmpty(roleToPermisBean.getRoleId(),"E00000001");
        Assert.notEmpty(roleToPermisBean.getPermissionId(),"E00000002");
        repository.delete(roleToPermisBean);
    }
}

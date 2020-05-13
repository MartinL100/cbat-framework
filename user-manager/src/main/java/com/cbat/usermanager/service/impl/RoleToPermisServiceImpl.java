package com.cbat.usermanager.service.impl;


import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.dao.RoleToPermisRepository;
import com.cbat.usermanager.service.IRoleToPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleToPermisServiceImpl implements IRoleToPermisService {
    @Autowired
    private RoleToPermisRepository repository;
    @Override
    public void add(RoleToPermisBean roleToPermisBean) {
        Assert.notEmpty(roleToPermisBean.getRoleId(),"角色编号不能为空");
        Assert.notEmpty(roleToPermisBean.getPermissionId(),"许可编号不能为空");
        repository.save(roleToPermisBean);
    }

    @Override
    public void del(RoleToPermisBean roleToPermisBean) {
        Assert.notEmpty(roleToPermisBean.getRoleId(),"角色编号不能为空");
        Assert.notEmpty(roleToPermisBean.getPermissionId(),"许可编号不能为空");
        repository.delete(roleToPermisBean);
    }

    @Override
    public void addAll(List<RoleToPermisBean> roleToPermisBeans) {
        repository.saveAll(roleToPermisBeans);
    }

    @Override
    public List<RoleToPermisBean> findByPermisId(String permissionId) {
        return repository.findByPermissionId(permissionId);
    }
}

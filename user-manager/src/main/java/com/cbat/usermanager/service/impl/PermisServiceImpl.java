package com.cbat.usermanager.service.impl;


import com.cbat.exception.bean.response.PageQueryResponse;
import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.dao.PermissionRepository;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleToPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisServiceImpl implements IPermisService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    IRoleToPermisService roleToPermisService;
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

    @Override
    public void addAll(Iterable<PermissionBean> permissionIterable) {
        permissionRepository.saveAll(permissionIterable);
    }

    @Override
    public PageQueryResponse<PermissionBean> pageQuery(PermissionBean permissionBean, Pageable pageable) {
        Example<PermissionBean> example = Example.of(permissionBean);
        Page<PermissionBean> permiss = permissionRepository.findAll(example, pageable);
        return new PageQueryResponse<PermissionBean>(permiss.toList(), (int) permiss.getTotalElements());
    }

    @Override
    public void del(String permissionId) {
        List<RoleToPermisBean> roleToPermisBeans = roleToPermisService.findByPermisId(permissionId);
        Assert.notNull(roleToPermisBeans,"还有角色拥有该权限，不能删除该权限");
        permissionRepository.deleteById(permissionId);
    }


}

package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.PermissionBean;

import java.util.List;

public interface IPermisService {
    List<PermissionBean> getPermises(String roleId);
    void addPermis(PermissionBean permissionBean);
    List<PermissionBean> findAll();
}

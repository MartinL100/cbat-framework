package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.PermissionBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPermisService {
    List<PermissionBean> getPermises(String roleId);
    void addPermis(PermissionBean permissionBean);
    List<PermissionBean> findAll();
    void addAll(Iterable<PermissionBean> permissionIterable);
    Page<PermissionBean> pageQuery(PermissionBean permissionBean, Pageable pageable);
    void del(String permissionId);
}

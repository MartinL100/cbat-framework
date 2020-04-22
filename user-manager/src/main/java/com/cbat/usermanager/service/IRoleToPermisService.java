package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.RoleToPermisBean;

import java.util.List;

public interface IRoleToPermisService {
    void add(RoleToPermisBean roleToPermisBean);
    void del(RoleToPermisBean roleToPermisBean);
    void addAll(List<RoleToPermisBean> roleToPermisBeans);
    List<RoleToPermisBean> findByPermisId(String permissionId);
}

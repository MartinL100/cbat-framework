package com.cbat.usermanager.service;


import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;

import java.util.List;

public interface IRoleService {
    List<RoleBean> findByUserId(String userId);
    void addRole(RoleBean roleBean);
    void del(String roleId);
}

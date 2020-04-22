package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserToRoleRepository extends JpaRepository<UserToRoleBean,String> {
    List<UserBean> findByRoleId(String roleId);
    List<RoleBean> findByUserId(String userId);
}

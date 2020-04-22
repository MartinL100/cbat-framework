package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.RoleToPermisBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleToPermisRepository extends JpaRepository<RoleToPermisBean,String> {

    List<RoleToPermisBean> findByPermissionId(String permissionId);
}

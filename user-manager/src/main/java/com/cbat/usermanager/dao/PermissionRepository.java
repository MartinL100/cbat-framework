package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionBean,String> {
        /**
         * 查询该角色拥有的所有权限
         * @param roleId
         * @return
         */
        @Query(nativeQuery = true,
                value = "SELECT p.`permission_name`,p.`permission_url`,p.`permission_id` " +
                        "FROM t_role r JOIN t_role_to_permis rp ON r.`role_id` = rp.`role_id` " +
                        "JOIN t_permission p ON rp.`permission_id` = p.`permission_id` " +
                        " WHERE r.`role_id` =:roleId")
        List<PermissionBean>getPermissionBeansByRoleId(@Param("roleId") String roleId);


}

package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.PermissionBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionBean,String> {

        @Query(nativeQuery = true,
                value = "SELECT p.`permission_name`,p.`permission_url`,p.`permission_id`\n" +
                        "FROM t_role r JOIN t_role_to_permis rp ON r.`role_id` = rp.`role_id`\n" +
                        "JOIN t_permission p ON rp.`permission_id` = p.`permission_id`\n" +
                        " WHERE r.`role_id` =:roleId")
        List<PermissionBean>getPermissionBeansByRoleId(@Param("roleId") String roleId);
}

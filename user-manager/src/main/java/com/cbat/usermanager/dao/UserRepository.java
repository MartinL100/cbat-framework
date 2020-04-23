package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserBean,String> {

    UserBean findByPwdAndUserName(String pwd, String userName);
    UserBean findByUserName(String userName);
    /**
     * 查询拥有该权限的所有用户
     * @param permissionId
     * @return
     */
    @Query(nativeQuery = true,
            value = "SELECT  u.*" +
                    "FROM " +
                    "  t_user u  " +
                    "  JOIN t_user_to_role ur  " +
                    "    ON u.`user_id` = ur.`user_id`  " +
                    "  JOIN t_role r  " +
                    "    ON ur.`role_id` = r.role_id  " +
                    "  JOIN t_role_to_permis rp  " +
                    "    ON r.`role_id` = rp.`role_id`  " +
                    "    WHERE rp.`permission_id`=:permissionId")
    List<UserBean> getUsersByPermissionId(@Param("permissionId") String permissionId);

    @Query(nativeQuery = true,
            value = "SELECT u.* " +
                    "FROM " +
                    "  t_user u  " +
                    "  JOIN t_user_to_role ur  " +
                    "    ON u.user_id = ur.user_id  " +
                    "    WHERE ur.role_id=:roleId")
    List<UserBean> getUsersByRoleId(@Param("roleId") String roleId);
}

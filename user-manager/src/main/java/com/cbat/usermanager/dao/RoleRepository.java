package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleBean,String> {


    @Query(value ="SELECT r.role_id,r.role_name \n" +
            " FROM t_role r\n" +
            " JOIN t_user_to_role ur ON ur.role_id=r.role_id" +
            " JOIN t_user u ON u.user_id = ur.user_id" +
            " WHERE u.user_id =:userId"
    ,nativeQuery = true)
    List<RoleBean>getRoleBeans(@Param("userId") String userId);
}

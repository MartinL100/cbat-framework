package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.UserToRoleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToRoleRepository extends JpaRepository<UserToRoleBean,String> {
}

package com.cbat.usermanager.dao;

import com.cbat.usermanager.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean,String> {

    UserBean findByPwdAndUserName(String pwd, String userName);
    UserBean findByUserName(String userName);
}

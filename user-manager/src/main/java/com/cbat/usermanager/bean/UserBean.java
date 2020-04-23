package com.cbat.usermanager.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "t_user")
public class UserBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    private String userId;
    @Column(length = 32)
    private String userName;
    @Column(length = 32)
    private String pwd;
    @Column(length = 32)
    private String tel;
    @Transient
    private List<RoleBean> roles;

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public UserBean() {
    }

    public UserBean(String userName,String userId) {
        this.userName = userName;
        this.userId = userId;
    }
}

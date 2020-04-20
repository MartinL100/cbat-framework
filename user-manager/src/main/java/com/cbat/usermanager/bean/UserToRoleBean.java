package com.cbat.usermanager.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_userToRole")
public class UserToRoleBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    private String userToRoleId;
    @Column(length = 32)
    private String userId;
    @Column(length = 32)
    private String roleId;

    public String getUserToRoleId() {
        return userToRoleId;
    }

    public void setUserToRoleId(String userToRoleId) {
        this.userToRoleId = userToRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

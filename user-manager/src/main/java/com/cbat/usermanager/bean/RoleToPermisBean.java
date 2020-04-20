package com.cbat.usermanager.bean;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_roleToPermis")
public class RoleToPermisBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    private String roleToPermisId;
    @Column(length = 32)
    private String roleId;
    @Column(length = 32)
    private String permissionId;

    public String getRoleToPermisId() {
        return roleToPermisId;
    }

    public void setRoleToPermisId(String roleToPermisId) {
        this.roleToPermisId = roleToPermisId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}

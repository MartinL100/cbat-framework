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
@Table(name = "t_role")
public class RoleBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    private String roleId;
    @Column(length = 32)
    private String roleName;
    @Transient
    private List<PermissionBean>permissions;

    public List<PermissionBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionBean> permissions) {
        this.permissions = permissions;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

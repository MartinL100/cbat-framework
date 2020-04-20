package com.cbat.usermanager.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_Permission")
public class PermissionBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    private String permissionId;
    @Column(length = 32)
    private String permissionName;
    @Column(length = 128)
    private String permissionUrl;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }
}

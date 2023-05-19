package com.example.spring_security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_role")
public class AppRole {

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleID;

    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    public Long getRoleId() {
        return roleID;
    }

    public void setRoleId(Long roleId) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
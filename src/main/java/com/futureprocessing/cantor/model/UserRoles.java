package com.futureprocessing.cantor.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_roles_id")
    private int id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "role_id")
    private int roleId;

    public UserRoles() {
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}

package com.futureprocessing.cantor.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role_name")
    private String roleName;
    @OneToOne(mappedBy = "roles")
    private User user;

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

}

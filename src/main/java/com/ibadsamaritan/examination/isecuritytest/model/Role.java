package com.ibadsamaritan.examination.isecuritytest.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer roleId;

    @Column(name = "role_name")
    String roleName;
}

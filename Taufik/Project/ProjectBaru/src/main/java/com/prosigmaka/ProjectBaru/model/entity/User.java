package com.prosigmaka.ProjectBaru.model.entity;

import javax.persistence.*;

@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue
    @Column
    private String idUser;
    @Column
    private String password;
    @Column(unique = true)
    private String email;
}

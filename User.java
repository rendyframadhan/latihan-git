package com.infosys.training.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mst_user")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String address;
    private String umur;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

}

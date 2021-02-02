package com.infosys.training.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "mst_role")
public class Role {

    @Id
    private String id;
    private String roleName;
    private String description;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissions;

}

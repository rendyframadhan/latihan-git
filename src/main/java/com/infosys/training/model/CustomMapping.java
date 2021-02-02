package com.infosys.training.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SqlResultSetMapping(name = "QueryNativeCustom", entities = {
        @EntityResult(entityClass = CustomMapping.class, fields = {
                @FieldResult(name = "id", column = "id"),
                @FieldResult(name = "userName", column = "nama_user"),
                @FieldResult(name = "roleName", column = "role_name"),
                @FieldResult(name = "url", column = "url"),
                @FieldResult(name = "email", column = "email"),
                @FieldResult(name = "umur", column = "umur")


        })
})
public class CustomMapping {
        @Id
        private String id;
        private String userName;
        private String roleName;
        private String url;
        private String email;
        private String umur;


}

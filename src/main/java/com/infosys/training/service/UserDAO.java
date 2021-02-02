package com.infosys.training.service;

import com.infosys.training.model.CustomMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserDAO {

    @Autowired
    private EntityManager em;

    public List<CustomMapping> getCustomQueryNative(){
        String nativeQueryScript ="SELECT RAND(100) as id, u.username as nama_user,u.email,u.umur,r.role_name,p.url FROM mst_user u \n" +
                "INNER JOIN mst_role r on r.id = u.role_id \n" +
                "INNER JOIN cfg_permission p on p.role_id = r.id \n";

        Query query = em.createNativeQuery(nativeQueryScript, "QueryNativeCustom");
        List<CustomMapping> list = query.getResultList();


        return list;
    }
}

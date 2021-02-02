package com.infosys.training.model.repository;

import com.infosys.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}

package com.echappeebelle.users.dao;

import com.echappeebelle.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends  JpaRepository<User, Integer> {

}

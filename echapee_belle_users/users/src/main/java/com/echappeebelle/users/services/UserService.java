package com.echappeebelle.users.services;


import com.echappeebelle.users.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    User save(User vehicle);
    User update(int id, User vehicle);
    void deleteById(int id);

}

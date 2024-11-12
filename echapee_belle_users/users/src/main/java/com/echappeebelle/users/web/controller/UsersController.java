package com.echappeebelle.users.web.controller;


import com.echappeebelle.users.model.User;
import com.echappeebelle.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    //CONSTRUCTOR*******************************************************************************************************
    private final UserService userService;
    @Autowired

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //ROUTE ALL USERS***************************************************************************************************
    @GetMapping("/user")
    public List<User> AllUsers() {
        return userService.findAll();
    }

    //ROUTE USERS ID****************************************************************************************************

    @GetMapping(value = "/user/{id}")
    public User afficherUnUser(@PathVariable int id) {
        return userService.findById(id).orElse(null);
    }

    //ROUTE CREATE USER*************************************************************************************************
    @PostMapping(value="/user")
    public User ajouterUnClient(@RequestBody User user) {
                return userService.save(user);

    }
    //ROUTE UPDATE USER*************************************************************************************************
    @PutMapping(value = "/user/{id}")
    public User modifierUnClient(@PathVariable int id , @RequestBody User user) {
        user.setId(id);
        return userService.update(id,user);
    }

    //ROUTE DELETE USER*************************************************************************************************
    @DeleteMapping(value = "/user/{id}")
    public void supprimerUnClient(@PathVariable int id) {
        userService.deleteById(id);
    }
}

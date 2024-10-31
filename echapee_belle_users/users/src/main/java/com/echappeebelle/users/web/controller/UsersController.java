package com.echappeebelle.users.web.controller;


import com.echappeebelle.users.dao.UserDao;
import com.echappeebelle.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UsersController {

    //CONSTRUCTOR*******************************************************************************************************
    private final UserDao userDao;
    @Autowired

    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    //ROUTE ALL USERS***************************************************************************************************
    @GetMapping("/user")
    public List<User> AllUsers() {
        return userDao.findAll();
    }

    //ROUTE USERS ID****************************************************************************************************

    @GetMapping(value = "/user/{id}")
    public User afficherUnProduit(@PathVariable Long id) {
        return userDao.findById(id).orElse(null);
    }

    //ROUTE CREATE USER*************************************************************************************************
    @PostMapping(value="/user/{id}")
    public User ajouterUnClient(@RequestBody User user, @PathVariable int id) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Boolean> isValid = restTemplate.getForEntity("http://127.0.0.1:8081/licenses/" + user.getLicense_number(),
                    Boolean.class, user.getLicense_number());

            if (Boolean.TRUE.equals(isValid.getBody())) {
                user.setId(id);
                return userDao.save(user);
            } else {
                throw new Exception("permis not valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //ROUTE UPDATE USER*************************************************************************************************
    @PutMapping(value = "/user/{id}")
    public User modifierUnClient(@PathVariable int id , @RequestBody User user) {
        user.setId(id);
        return userDao.save(user);
    }

    //ROUTE DELETE USER*************************************************************************************************
    @DeleteMapping(value = "/user/{id}")
    public void supprimerUnClient(@PathVariable Long id) {
        userDao.deleteById(id);
    }
}

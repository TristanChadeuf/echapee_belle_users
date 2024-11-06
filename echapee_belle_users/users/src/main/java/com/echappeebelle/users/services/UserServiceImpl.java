package com.echappeebelle.users.services;


import com.echappeebelle.users.dao.UserDao;
import com.echappeebelle.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<User> findAll(){
        return userDao.findAll();
    }
    public Optional<User> findById(int id) {
        return userDao.findById(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }
    public User update(int id,User newUser) {
        Optional<User> optionalUser = userDao.findById(id);

        if(optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            existingUser.setName(newUser.getName());
            existingUser.setFirst_name(newUser.getFirst_name());
            existingUser.setAge(newUser.getAge());
            existingUser.setBirth_date(newUser.getBirth_date());
            existingUser.setLicense_number(newUser.getLicense_number());
            existingUser.setLicense_obtention_date(newUser.getLicense_obtention_date());

           newUser = userDao.save(existingUser);
            return newUser;
        }
        return null;
    }

    public void deleteById(int id) {
        if(userDao.existsById(id)){
            userDao.deleteById(id);
        }else{
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }
    public void hi(){
        System.out.println("hi");
    }

}

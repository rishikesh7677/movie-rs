package com.example.springboot.service;
import com.example.springboot.entities.User;
import com.example.springboot.repositary.CourseRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.springboot.repositary.UserRepositary;

import java.util.Optional;

@Service
public class userService {
    private UserRepositary userrepositary;

    @Autowired
    public userService(UserRepositary  userrepositary){
        this.userrepositary=userrepositary;

    }


    public Optional<User> getBy(Integer id)
    {
        Optional<User> result;
        boolean exist=userrepositary.existsById(id);
        if(!exist){
            throw new IllegalStateException("User does not exist");
        }
        else {
            result = userrepositary.findById(id);
            return result;
        }
    }
    public User create(User aduser){
        User result= userrepositary.save(aduser);
        return result;

    }
    public User update(User aduser){
        boolean exist=userrepositary.existsById(aduser.getId());
        if(!exist){
            throw new IllegalStateException("User does not exist");
        }
        User result= userrepositary.save(aduser);
        return result;

    }
}

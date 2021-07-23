package com.example.springboot.controller;

import com.example.springboot.entities.UserCart;
import com.example.springboot.entities.orderdetails;
import com.example.springboot.service.UserCartService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class UsercartController {

    private  UserCartService userCartService;
    @Autowired
    public UsercartController(UserCartService userCartService){

        this.userCartService=userCartService;
    }

    @PostMapping("/addcart/{course_id}/{user_id}")
    public UserCart addcart(@PathVariable(value = "course_id")  int cid,@PathVariable(value = "user_id") int uid){
        return userCartService.addcart(cid,uid);
    }
    @DeleteMapping("/delcart/{course_id}/{user_id}")
    public String delcart(@PathVariable(value = "course_id")  int cid, @PathVariable(value = "user_id") int uid){
        return userCartService.delcart(cid,uid);
    }
    @PutMapping("/demap/{course_id}")
    public  String demap(@PathVariable(value = "course_id") int cid){
        return  userCartService.demap(cid);
    }

    @GetMapping("/cartofuser/{user_id}")
    public ArrayList<orderdetails> cartofuser(@PathVariable(value = "user_id") int uid){
        return userCartService.cartofuser(uid);
    }
}

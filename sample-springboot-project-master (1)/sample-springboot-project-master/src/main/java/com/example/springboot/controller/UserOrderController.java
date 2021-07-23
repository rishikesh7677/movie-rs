package com.example.springboot.controller;

import com.example.springboot.entities.UserOrder;
import com.example.springboot.entities.orderdetails;
import com.example.springboot.service.UserOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserOrderController {
    private UserOrderService userOrderService;
    @Autowired
    public UserOrderController(UserOrderService userOrderService){

        this.userOrderService=userOrderService;
    }

    @PostMapping("/place/{course_id}/{user_id}")
    public  UserOrder placeorder(@PathVariable(value = "course_id")  int cid,@PathVariable(value = "user_id") int uid){
        return userOrderService.placeorder(cid,uid);
    }

    @GetMapping("/orders/{user_id}")
    public ArrayList<orderdetails> getdetails(@PathVariable(value = "user_id") int uid){
        return userOrderService.getdetails(uid);
    }

}

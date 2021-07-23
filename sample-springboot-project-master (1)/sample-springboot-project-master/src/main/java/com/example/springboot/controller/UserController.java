package com.example.springboot.controller;
import com.example.springboot.entities.UserCart;
import com.example.springboot.service.UserCartService;
import com.example.springboot.service.userService;
import com.example.springboot.entities.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class UserController {
	private userService userservice;
	private  UserCartService userCartService;
	@Autowired
	public UserController(userService userservice, UserCartService userCartService){
		this.userservice=userservice;
		this.userCartService=userCartService;
	}


	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot";
	}

	@GetMapping("/user/{id}")
	public Optional<User> getBy(@PathVariable(value = "id") int id){
		return  userservice.getBy(id);
	}
	@PostMapping("/adduser")
	public  User create(@RequestBody User aduser){
		return userservice.create(aduser);
	}
	@PutMapping("/updateUser")
	public  User update(@RequestBody User aduser){
		return userservice.create(aduser);
	}

}

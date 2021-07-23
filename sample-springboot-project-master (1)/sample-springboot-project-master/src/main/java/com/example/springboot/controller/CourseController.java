package com.example.springboot.controller;
import com.example.springboot.entities.Course;
import com.example.springboot.service.CourseService;
import com.example.springboot.service.UserCartService;
import com.example.springboot.service.userService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class CourseController {
    private CourseService courseservice;

    @Autowired
    public  CourseController( CourseService courseservice){

        this.courseservice=courseservice;
    }
    @PostMapping("/addcourse")
    public  Course addcourse(@RequestBody Course adcourse){
        return courseservice.addcourse(adcourse);
    }

    @DeleteMapping("/deletecourse/{id}")
    public Optional<Course> deletecourse(@PathVariable(value = "id") int id)
    {
        return  courseservice.deletecourse(id);
    }
}

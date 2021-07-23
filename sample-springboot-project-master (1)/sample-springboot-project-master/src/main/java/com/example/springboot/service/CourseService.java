package com.example.springboot.service;
import com.example.springboot.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.springboot.repositary.CourseRepositary;

import java.util.Optional;

@Service
public class CourseService {
    private CourseRepositary courserepositary;

    @Autowired
    public CourseService(CourseRepositary  courserepositary){
        this.courserepositary=courserepositary;

    }

    public Course addcourse(Course adcourse){
        Course result= courserepositary.save(adcourse);
        return result;

    }
    public Optional<Course> deletecourse(int id){
        boolean exist=courserepositary.existsById(id);
        if(!exist){
            throw new IllegalStateException("course does not exist");
        }
        else {
            Optional<Course> result = courserepositary.findById(id);
            courserepositary.deleteById(id);
            return result;
        }

    }


}

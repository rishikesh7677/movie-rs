package com.example.springboot.repositary;

import com.example.springboot.entities.Course;
import com.example.springboot.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepositary extends CrudRepository<Course,Integer> {
}

package com.example.springboot.entities;
import  com.example.springboot.entities.User;
import  com.example.springboot.entities.Course;

import java.io.Serializable;
import java.util.Objects;

public class orderdetails implements Serializable {

    private User user;
    private  Course course;

    public orderdetails(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    @Override
    public String toString() {
        return "orderdetails{" +
                "user=" + user +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        orderdetails that = (orderdetails) o;
        return Objects.equals(user, that.user) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, course);
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }
}

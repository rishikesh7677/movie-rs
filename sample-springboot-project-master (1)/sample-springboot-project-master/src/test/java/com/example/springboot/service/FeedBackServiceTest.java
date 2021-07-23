package com.example.springboot.service;

import com.example.springboot.repositary.UserCartRepositary;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springboot.entities.*;
import com.example.springboot.repositary.CourseRepositary;
import  com.example.springboot.repositary.FeedBackRepositary;
import com.example.springboot.repositary.UserRepositary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class FeedBackServiceTest {
    private  FeedBackService feedBackService;
    @Mock private FeedBackRepositary feedBackRepositary;
    @Mock private CourseRepositary courseRepositary;
    @Mock private UserRepositary userRepositary;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        feedBackService=new FeedBackService(feedBackRepositary,userRepositary,courseRepositary);
    }
    @Test
    void addreview(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        String rvw="good";
        Integer rate=3;
        FeedBack testd=new FeedBack(cour,rvw,rate,user);
        ArrayList<User> user1 = new ArrayList<User>();
        ArrayList<Integer> x=new ArrayList();
        x.add(1);
        user1.add(user);
        FeedBack mockcart= new FeedBack(cour,rvw,rate,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);
        Mockito.when(feedBackRepositary.save(testd)).thenReturn(mockcart);
        Mockito.when(userRepositary.findAllById(x)).thenReturn(user1);
        ArrayList<Integer> y=new ArrayList();
        y.add(2);
        ArrayList<Course> Course1 = new ArrayList<Course>();
        Course1.add(cour);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);
        Mockito.when(courseRepositary.findAllById(y)).thenReturn(Course1);
        FeedBack result= feedBackService.addfeedback(2,1,testd);
        assertEquals(mockcart.getCourse(),result.getCourse());
        assertEquals(mockcart.getUser(),result.getUser());
    }
}
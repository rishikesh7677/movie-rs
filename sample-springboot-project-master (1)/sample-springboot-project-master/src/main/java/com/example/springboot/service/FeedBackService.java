package com.example.springboot.service;
import com.example.springboot.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import  com.example.springboot.repositary.UserRepositary;
import  com.example.springboot.repositary.CourseRepositary;
import  com.example.springboot.repositary.FeedBackRepositary;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class FeedBackService {

    private FeedBackRepositary feedBackRepositary;
    private  UserRepositary userRepositary;
    private  CourseRepositary courseRepositary;
    @Autowired
    public FeedBackService(FeedBackRepositary feedBackRepositary , UserRepositary userRepositary, CourseRepositary courseRepositary){
        this.feedBackRepositary=feedBackRepositary;
        this.userRepositary=userRepositary;
        this.courseRepositary=courseRepositary;
    }
    public FeedBack addfeedback(int cid,int uid,FeedBack fdback){
        if(!userRepositary.existsById(uid)){
            throw new IllegalStateException("User does not exist");
        }
        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Integer> x=new ArrayList();
        x.add(uid);
        //finding details from user tabel with userid-uid
        user= (ArrayList<User>) userRepositary.findAllById(x);
        ArrayList<Course> course = new ArrayList();
        ArrayList<Integer> y=new ArrayList();
        y.add(cid);
        if(!courseRepositary.existsById(cid)){
            throw new IllegalStateException("course does not exist");
        }
        //finding course from course tabel with course id
        course= (ArrayList<Course>) courseRepositary.findAllById(y);
        String rvw=fdback.getReview();
        Integer rate=fdback.getRatings();
        FeedBack adfdback= new FeedBack(course.get(0),rvw,rate,user.get(0));
        FeedBack result= feedBackRepositary.save(adfdback);
        return result;

    }
}

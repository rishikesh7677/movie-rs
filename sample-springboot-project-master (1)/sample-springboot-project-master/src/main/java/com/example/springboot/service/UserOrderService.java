package com.example.springboot.service;
import com.example.springboot.entities.User;
import com.example.springboot.entities.orderdetails;
import com.example.springboot.repositary.UserOrderRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.springboot.entities.Course;
import  com.example.springboot.repositary.UserRepositary;
import  com.example.springboot.repositary.CourseRepositary;
import  com.example.springboot.entities.UserOrder;

import java.util.ArrayList;

@Service
public class UserOrderService {
    private UserOrderRepositary userOrderRepositary;
    private  UserRepositary userRepositary;
    private  CourseRepositary courseRepositary;
    @Autowired
    public UserOrderService(UserOrderRepositary userOrderRepositary , UserRepositary userRepositary, CourseRepositary courseRepositary){
        this.userOrderRepositary=userOrderRepositary;
        this.userRepositary=userRepositary;
        this.courseRepositary=courseRepositary;
    }

    public  UserOrder placeorder(int cid,int uid){
        if(!userRepositary.existsById(uid)){
            throw new IllegalStateException("User does not exist");
        }
        //finding user by id
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
        UserOrder adcart= new UserOrder(course.get(0),user.get(0));
        UserOrder result= userOrderRepositary.save(adcart);
        return result;
    }

    public ArrayList<orderdetails> getdetails(int uid){
        if(!userRepositary.existsById(uid)){
            throw new IllegalStateException("User does not exist");
        }

        ArrayList<UserOrder> orderofuser= new ArrayList();

        orderofuser=(ArrayList<UserOrder>) userOrderRepositary.findAll();
        ArrayList<orderdetails> orderdetail=new ArrayList();

        for (UserOrder x:orderofuser) {
            User user=(x.getUser());
            Course course=(x.getCourse());
            if(user.getId()==uid)
            orderdetail.add(new orderdetails(user,course));

        }
        //return orderdetail;.
        ArrayList<orderdetails> orderString=new ArrayList<orderdetails>();
        for (orderdetails ordr: orderdetail) {
            orderString.add(ordr);
        }
        return orderString;
        //return  orderdetail;

    }
    }


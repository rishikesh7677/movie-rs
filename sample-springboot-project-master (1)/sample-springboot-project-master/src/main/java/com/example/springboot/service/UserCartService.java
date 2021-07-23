package com.example.springboot.service;
import com.example.springboot.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.springboot.repositary.UserCartRepositary;
import  com.example.springboot.repositary.UserRepositary;
import  com.example.springboot.repositary.CourseRepositary;

import java.util.ArrayList;

@Service

public class UserCartService {
    private  UserCartRepositary userCartRepositary;
    private  UserRepositary userRepositary;
    private  CourseRepositary courseRepositary;
    @Autowired
    public UserCartService(UserCartRepositary userCartRepositary , UserRepositary userRepositary, CourseRepositary courseRepositary){
        this.userCartRepositary=userCartRepositary;
        this.userRepositary=userRepositary;
        this.courseRepositary=courseRepositary;
    }

    public UserCart addcart(int cid,int uid){
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
         UserCart adcart= new UserCart(course.get(0),user.get(0));
        UserCart result= userCartRepositary.save(adcart);
        return result;

    }

    //delete cart->first extract all course then do it
    public String delcart(int cid, int uid) {
        if (!userRepositary.existsById(uid)) {
            throw new IllegalStateException("User does not exist");
        }
        if (!courseRepositary.existsById(cid)) {
            throw new IllegalStateException("course does not exist");
        }
        //all cart details
        ArrayList<UserCart> cartofuser = new ArrayList();
        cartofuser = (ArrayList<UserCart>) userCartRepositary.findAll();

        //traversing through each cart
        for (UserCart x : cartofuser) {
            int cartid = x.getId();
            User user = (x.getUser());
            Course course = (x.getCourse());
            if (user.getId() == uid && course.getId() == cid) {
                UserCart updated = new UserCart();
                updated.setId(cartid);
                userCartRepositary.save(updated);
                userCartRepositary.deleteById(cartid);

                return "Succes";
            }

        }
        return "Not Succuess";
    }

    public String demap(int cid){
        if(!courseRepositary.existsById(cid)){
            throw new IllegalStateException("course does not exist");
        }
        //all cart details
        ArrayList<UserCart> cartofuser= new ArrayList();
        cartofuser=(ArrayList<UserCart>) userCartRepositary.findAll();

        //traversing through each cart
        for (UserCart x:cartofuser) {
            int cartid=x.getId();
            User user=(x.getUser());
            Course course=(x.getCourse());
            //System.out.println(cartid);
            if(course!=null && user!=null){
                UserCart updated = new UserCart();
                updated.setId(cartid);
                updated.setUser(user);
                userCartRepositary.save(updated);

            }

        }
        return "Success";

    }

    public ArrayList<orderdetails> cartofuser(int uid) {
        if(!userRepositary.existsById(uid)){
            throw new IllegalStateException("User does not exist");
        }

        //all cart details
        ArrayList<UserCart> cartofuser= new ArrayList();
        cartofuser=(ArrayList<UserCart>) userCartRepositary.findAll();

        ArrayList<orderdetails> orderdetail=new ArrayList();

        for (UserCart x:cartofuser) {
            User user=(x.getUser());
            Course course=(x.getCourse());
            if(user.getId()==uid)orderdetail.add(new orderdetails(user,course));

        }

        ArrayList<orderdetails> orderString=new ArrayList<orderdetails>();
        for (orderdetails ordr: orderdetail) {
            orderString.add(ordr);

        }
        return orderString;

    }
}

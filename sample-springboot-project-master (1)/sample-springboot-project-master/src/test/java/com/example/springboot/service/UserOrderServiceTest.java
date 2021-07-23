package com.example.springboot.service;

import com.example.springboot.entities.*;
import org.junit.jupiter.api.BeforeEach;
import com.example.springboot.repositary.CourseRepositary;
import com.example.springboot.repositary.UserRepositary;
import com.example.springboot.repositary.UserOrderRepositary;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserOrderServiceTest {
    private UserOrderService userOrderService;
    @Mock private UserOrderRepositary userOrderRepositary;
    @Mock private CourseRepositary courseRepositary;
    @Mock private UserRepositary userRepositary;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userOrderService=new UserOrderService(userOrderRepositary,userRepositary,courseRepositary);
    }

    //add to order tabel
    @Test
    void placeorder(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        //object of ordertype
        UserOrder testd=new UserOrder(cour,user);

        //find user
        ArrayList<User> user1 = new ArrayList<User>();
        ArrayList<Integer> x=new ArrayList();
        x.add(1);
        user1.add(user);
        //mocked userorder type
        UserOrder mockcart= new UserOrder(cour,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);
        Mockito.when(userOrderRepositary.save(testd)).thenReturn(mockcart);
        Mockito.when(userRepositary.findAllById(x)).thenReturn(user1);

        //find course to add from course tabel
        ArrayList<Integer> y=new ArrayList();
        y.add(2);
        ArrayList<Course> Course1 = new ArrayList<Course>();
        Course1.add(cour);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);
        Mockito.when(courseRepositary.findAllById(y)).thenReturn(Course1);
        UserOrder result= userOrderService.placeorder(2,1);
        assertEquals(mockcart.getCourse(),result.getCourse());
        assertEquals(mockcart.getUser(),result.getUser());
    }

    @Test
    void getorder(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        //object of ordertype
        UserOrder testd=new UserOrder(cour,user);

        //find user
        //mocked userorder type
        UserOrder mockcart= new UserOrder(cour,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);


        ArrayList<UserOrder> user2 = new ArrayList<UserOrder>();
        user2.add(testd);
        Mockito.when(userOrderRepositary.findAll()).thenReturn(user2);
        ArrayList<orderdetails> result= userOrderService.getdetails(1);
        ArrayList<orderdetails> expected= new ArrayList<orderdetails>();
        orderdetails orders=new orderdetails(user,cour);
        expected.add(orders);
        assertEquals(true,expected.equals(result));

    }
}
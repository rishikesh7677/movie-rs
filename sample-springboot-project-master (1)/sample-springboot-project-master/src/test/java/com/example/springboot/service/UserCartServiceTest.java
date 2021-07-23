package com.example.springboot.service;

import com.example.springboot.entities.*;
import com.example.springboot.repositary.CourseRepositary;
import com.example.springboot.repositary.UserCartRepositary;
import com.example.springboot.repositary.UserRepositary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserCartServiceTest {
    private UserCartService userCartService;
     @Mock private UserCartRepositary userCartRepositary;
    @Mock private CourseRepositary courseRepositary;
    @Mock private UserRepositary userRepositary;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userCartService=new UserCartService(userCartRepositary,userRepositary,courseRepositary);
    }
    @Test
    void addtocart(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        UserCart testd=new UserCart(cour,user);
        ArrayList<User> user1 = new ArrayList<User>();
        ArrayList<Integer> x=new ArrayList();
        x.add(1);
        user1.add(user);
        UserCart mockcart= new UserCart(cour,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);
        Mockito.when(userCartRepositary.save(testd)).thenReturn(mockcart);
        Mockito.when(userRepositary.findAllById(x)).thenReturn(user1);
        ArrayList<Integer> y=new ArrayList();
        y.add(2);
        ArrayList<Course> Course1 = new ArrayList<Course>();
        Course1.add(cour);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);
        Mockito.when(courseRepositary.findAllById(y)).thenReturn(Course1);
        UserCart result= userCartService.addcart(2,1);
        assertEquals(mockcart.getCourse(),result.getCourse());
        assertEquals(mockcart.getUser(),result.getUser());
    }
    @Test
    void addtocartuserNotexist() {
        User user1 = new User(1, "DragonBall", "goku", "singh", "earth.com");
        Course cour = new Course(2, "React", "goku", "singh", 860);
        Mockito.when(userRepositary.existsById(1)).thenReturn(false);

        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Integer> x = new ArrayList();
        x.add(1);
        user = (ArrayList<User>) userRepositary.findAllById(x);
        ArrayList<Course> course = new ArrayList<Course>();
        ArrayList<Integer> y = new ArrayList();
        y.add(2);
        course = (ArrayList<Course>) courseRepositary.findAllById(y);
        UserCart mockcart = new UserCart(cour, user1);
        UserCart adcart = new UserCart(cour, user1);
        Mockito.when(userCartRepositary.save(adcart)).thenReturn(mockcart);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);
        ArrayList result=new ArrayList();
        assertEquals(userRepositary.findAllById(x),result);


    }
    @Test
    void addtocartcourseNotexist() {
        User user1 = new User(1, "DragonBall", "goku", "singh", "earth.com");
        Course cour = new Course(2, "React", "goku", "singh", 860);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);

        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Integer> x = new ArrayList();
        x.add(1);
        user = (ArrayList<User>) userRepositary.findAllById(x);
        ArrayList<Course> course = new ArrayList<Course>();
        ArrayList<Integer> y = new ArrayList();
        y.add(2);
        course = (ArrayList<Course>) courseRepositary.findAllById(y);
        UserCart mockcart = new UserCart(cour, user1);
        UserCart adcart = new UserCart(cour, user1);
        Mockito.when(userCartRepositary.save(adcart)).thenReturn(mockcart);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(false);
        ArrayList result=new ArrayList();
        assertEquals(userRepositary.findAllById(x),result);
    }

    @Test
    void deletefromcart(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        UserCart testd=new UserCart(cour,user);
        ArrayList<UserCart> user1 = new ArrayList<UserCart>();
        user1.add(testd);
        UserCart mockcart= new UserCart(cour,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);
        Mockito.when(userCartRepositary.findAll()).thenReturn(user1);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);

        assertEquals(userCartService.delcart(2,1),"Succes");

    }
    @Test
    void deletefromcartusernotexist(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        UserCart testd=new UserCart(cour,user);
        ArrayList<UserCart> user1 = new ArrayList<UserCart>();
        user1.add(testd);
        UserCart mockcart= new UserCart(cour,user);
        ArrayList<UserCart> userCart2 = new ArrayList<UserCart>();
        Mockito.when(userRepositary.existsById(1)).thenReturn(false);
        Mockito.when(userCartRepositary.findAll()).thenReturn(userCart2);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);
        ArrayList result=new ArrayList();
        assertEquals(userCartRepositary.findAll(),result);

    }
    @Test
    void deletefromcartCoursenotexist(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        UserCart testd=new UserCart(cour,user);
        ArrayList<UserCart> user1 = new ArrayList<UserCart>();
        user1.add(testd);
        UserCart mockcart= new UserCart(cour,user);
        ArrayList<UserCart> userCart2 = new ArrayList<UserCart>();
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);
        Mockito.when(userCartRepositary.findAll()).thenReturn(userCart2);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(false);
        ArrayList result=new ArrayList();
        assertEquals(userCartRepositary.findAll(),result);

    }
    @Test
    void demapmcart(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        UserCart testd=new UserCart(cour,user);
        ArrayList<UserCart> user1 = new ArrayList<UserCart>();
        user1.add(testd);
        UserCart mockcart= new UserCart(cour,user);
        Mockito.when(userCartRepositary.findAll()).thenReturn(user1);
        Mockito.when(courseRepositary.existsById(2)).thenReturn(true);

        assertEquals(userCartService.demap(2),"Success");

    }

    @Test
    void checkcartofuser(){
        User user=new User(1,"DragonBall" ,"goku","singh","earth.com");
        Course cour=new Course(2,"React" ,"goku","singh",860);

        //object of ordertype
        UserCart testd=new UserCart(cour,user);

        //find user
        //mocked userorder type
        UserOrder mockcart= new UserOrder(cour,user);
        Mockito.when(userRepositary.existsById(1)).thenReturn(true);


        ArrayList<UserCart> user2 = new ArrayList<UserCart>();
        user2.add(testd);
        Mockito.when(userCartRepositary.findAll()).thenReturn(user2);
        ArrayList<orderdetails> result= userCartService.cartofuser(1);
        ArrayList<orderdetails> expected= new ArrayList<orderdetails>();
        orderdetails orders=new orderdetails(user,cour);
        expected.add(orders);
        assertEquals(true,expected.equals(result));
    }

}
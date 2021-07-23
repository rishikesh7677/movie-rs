package com.example.springboot.service;

import com.example.springboot.entities.User;
import com.example.springboot.repositary.UserRepositary;
import javassist.bytecode.stackmap.BasicBlock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class userServiceTest {
    private userService userservice;
    @Mock private UserRepositary userrepositary;
    private Object IllegalMonitorStateException;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userservice=new userService(userrepositary);
    }
    @Test
    void whenuserisadded(){
        User student=new  User(50,"DragonBall" ,"goku","singh","earth.com");
        User mockedstudnet= new User(50,"DragonBall" ,"goku","singh","earth.com");
        Mockito.when(userrepositary.save(student)).thenReturn(mockedstudnet);
        //calling
        User result=userservice.create(student);
        assertEquals(50,result.getId());
    }
    @Test
    void  getapi(){
        Optional<User> student= Optional.of(new User(50, "DragonBall", "goku", "singh", "earth.com"));
        User mockedstudnet= new User(50,"DragonBall" ,"goku","singh","earth.com");
        Mockito.when(userrepositary.findById(50)).thenReturn(Optional.of(mockedstudnet));
        Mockito.when(userrepositary.existsById(50)).thenReturn(true);
        //calling
        Optional<User> result=userservice.getBy(50);
        assertEquals(result,student);

    }

    @Test
    void  putrequest(){
        User student= (new User(50, "DragonBallZ", "goku", "singh", "earth.com"));
        User mockedstudnet= new User(50,"DragonBallZ" ,"goku","singh","earth.com");
        Mockito.when(userrepositary.save(student)).thenReturn((mockedstudnet));
        Mockito.when(userrepositary.existsById(50)).thenReturn(true);
        //calling
        User result=userservice.update(student);
        assertEquals(result,student);

    }
}
package com.example.springboot.service;

import static org.junit.jupiter.api.Assertions.*;
import com.example.springboot.entities.Course;
import com.example.springboot.repositary.CourseRepositary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class CourseServiceTest {
    private CourseService courseservice;
    @Mock private CourseRepositary courserepositary;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        courseservice=new CourseService(courserepositary);
    }
    @Test
    void whenuserisadded(){
        Course cour=new Course(50,"React" ,"goku","singh",860);
        Course mockedCourse= new Course(50,"React" ,"goku","singh",860);
        Mockito.when(courserepositary.save(cour)).thenReturn(mockedCourse);
        //calling
        Course result=courseservice.addcourse(cour);
        assertEquals(50,result.getId());
    }
    @Test
    void  deletecourseapi(){
        Course cour=new Course(50,"React" ,"goku","singh",860);
        Optional<Course> mockedCourse= Optional.of(new Course(50, "React", "goku", "singh", 860));

        //calling
        Mockito.when(courserepositary.existsById(50)).thenReturn(true);
        Mockito.when(courserepositary.findById(50)).thenReturn(Optional.of(cour));
        Optional<Course> result=courseservice.deletecourse(cour.getId());
        assertEquals(result,mockedCourse);

    }


}
package com.example.springboot.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(name="coursename")
    private String coursename;
    @Column(name="instructor")
    private  String instructor;
    @Column(name="tag")
    private  String tag;
    @Column(name="price")
    private  Integer price;

    public Integer getId() {
        return id;
    }

    public Course() {
    }

    public Course(Integer id, String coursename, String instructor, String tag, Integer price) {
        this.id = id;
        this.coursename = coursename;
        this.instructor = instructor;
        this.tag = tag;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", instructor='" + instructor + '\'' +
                ", tag='" + tag + '\'' +
                ", price=" + price +
                ", usercart=" + usercart +
                '}';
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy="course") // maybe CascadeType.REMOVE is enough for you
    private List<UserCart> usercart = new ArrayList();
}
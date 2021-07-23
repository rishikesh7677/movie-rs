package com.example.springboot.entities;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OrderTable")
@Data
public class UserOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private  Course course;


    public UserOrder() {
    }

    public UserOrder(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName ="user_id")
    private  User user;
}

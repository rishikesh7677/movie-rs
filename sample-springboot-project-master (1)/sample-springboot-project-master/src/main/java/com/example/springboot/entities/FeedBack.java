package com.example.springboot.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedback")
@Data
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private  Course course;
    @Column(name = "review")
    private String review;
    @Column(name="ratings")
    private int ratings;
    public FeedBack() {
    }

    public FeedBack(Course course, String review, int ratings, User user) {
        this.course = course;
        this.review = review;
        this.ratings = ratings;
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName ="user_id")
    private  User user;

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

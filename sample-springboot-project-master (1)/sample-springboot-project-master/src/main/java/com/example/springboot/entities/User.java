package com.example.springboot.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usertabel")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name="displayname")
    private String displayname;
    @Column(name="firstname")
    private  String firstname;
    @Column(name="lastname")
    private  String lastname;
    @Column(name="email")
    private  String email;
    @Column(name="bio")
    private  String  bio;
    @Column(name="areaofinterest")
    private String[] areaofinterest;
    @Column(name="usertype")
    private  String usertype;
    @Column(name="experience")
    private int experience;
    @Column(name="domainexpertise")
    private String domainexpertise;
    @Column(name="role")
    private  String role;
    @Column(name="profilepic")
    String profilepic;

    public User() {
    }

    public User(Integer id, String displayname, String firstname, String lastname, String email) {
        this.displayname = displayname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id=id;
    }

    public int getId() {
        return id;
    }
/*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName ="userid")
    private List<UserCart> UserCart;*/
}

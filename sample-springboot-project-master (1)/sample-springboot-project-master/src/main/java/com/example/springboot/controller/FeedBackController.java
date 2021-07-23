package com.example.springboot.controller;

import com.example.springboot.entities.FeedBack;
import com.example.springboot.entities.UserCart;
import com.example.springboot.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedBackController {

    private FeedBackService feedBackService;

    @Autowired
    private FeedBackController(FeedBackService feedBackService){
        this.feedBackService=feedBackService;

    }
    @PostMapping("/addfeedback/{course_id}/{user_id}")
    public FeedBack addfeedback(@RequestBody FeedBack revw,@PathVariable(value = "course_id")  int cid, @PathVariable(value = "user_id") int uid){
        return feedBackService.addfeedback(cid,uid,revw);
    }
}

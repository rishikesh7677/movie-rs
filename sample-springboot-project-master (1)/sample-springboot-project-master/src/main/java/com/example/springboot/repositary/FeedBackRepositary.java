package com.example.springboot.repositary;

import com.example.springboot.entities.FeedBack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepositary extends  CrudRepository<FeedBack,Integer> {
}

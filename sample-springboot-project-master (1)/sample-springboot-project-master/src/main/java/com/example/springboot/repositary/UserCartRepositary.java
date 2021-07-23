package com.example.springboot.repositary;

import com.example.springboot.entities.UserCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepositary extends CrudRepository<UserCart,Integer> {
}

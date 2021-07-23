package com.example.springboot.repositary;
import com.example.springboot.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends CrudRepository<User,Integer> {
}

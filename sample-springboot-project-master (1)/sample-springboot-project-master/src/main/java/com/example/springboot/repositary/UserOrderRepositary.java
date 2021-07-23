package com.example.springboot.repositary;
import com.example.springboot.entities.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepositary extends CrudRepository<UserOrder,Integer> {
}

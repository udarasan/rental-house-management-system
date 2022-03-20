package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);

}

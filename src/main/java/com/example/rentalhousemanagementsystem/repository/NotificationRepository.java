package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Defect;
import com.example.rentalhousemanagementsystem.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    boolean existsById(int id);

    Notification findById(int id);
}

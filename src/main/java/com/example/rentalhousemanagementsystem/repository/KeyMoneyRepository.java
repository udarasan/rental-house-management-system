package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyMoneyRepository extends JpaRepository<Defect,Integer> {
}

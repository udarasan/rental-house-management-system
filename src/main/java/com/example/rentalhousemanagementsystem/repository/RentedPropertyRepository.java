package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.RentedProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedPropertyRepository extends JpaRepository<RentedProperty,Integer> {
    boolean existsByRecordId(int uid);
}

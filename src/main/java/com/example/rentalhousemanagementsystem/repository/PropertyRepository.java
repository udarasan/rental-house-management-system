package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property,Integer> {
    boolean existsByUnitId(int uid);
}

package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Sublet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubletRepository extends JpaRepository<Sublet,Integer> {

    boolean existsBySubletRecordID(int subletRecordID);
}

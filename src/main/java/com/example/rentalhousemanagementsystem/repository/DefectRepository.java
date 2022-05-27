package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository  extends JpaRepository<Defect,Integer> {


    boolean existsByDefectId(int defectId);

    Defect findByDefectId(int defectId);
}

package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.dto.NoticeDTO;
import com.example.rentalhousemanagementsystem.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Integer> {
    boolean existsById(int id);

    Notice findById(int id);
}

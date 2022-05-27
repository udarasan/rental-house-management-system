package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.KeyMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyMoneyRepository extends JpaRepository<KeyMoney,Integer> {
    boolean existsByTransactionID(int transactionID);
    KeyMoney findByTransactionID(int transactionID);
}
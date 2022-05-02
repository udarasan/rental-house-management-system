package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    boolean existsByPaymentId(long uid);

    @Modifying
    @Query(value = "UPDATE PAYMENT SET status =?2 WHERE payment_id=?1", nativeQuery = true)
    void changePaymentStatus(String paymentId,String paymentStatus);



}

package com.example.rentalhousemanagementsystem.repository;

import com.example.rentalhousemanagementsystem.entity.RentedProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RentedPropertyRepository extends JpaRepository<RentedProperty,Integer> {
    boolean existsByRecordId(int uid);
    RentedProperty findByRecordId(int recordId);

    @Query(value = "SELECT current_key_money_balance from rhmsystem.rented_property where record_id=?1",nativeQuery = true)
    String getCurrentKeyMoneyValue(String recordId);

    @Modifying
    @Query(value = "UPDATE rhmsystem.rented_property SET current_key_money_balance =?1 WHERE record_id=?2",nativeQuery = true)
    void updateCurrentKeyMoneyValue(String value,String recordId);
}

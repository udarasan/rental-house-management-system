package com.example.rentalhousemanagementsystem.dto;

import com.example.rentalhousemanagementsystem.entity.RentedProperty;
import com.example.rentalhousemanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KeyMoneyDTO {
    private int transactionID;
    private String value;
    private String date;
    private String description;
    private User deductedBy;
    private String remarks;
    private RentedProperty rentedPropertyID;
}
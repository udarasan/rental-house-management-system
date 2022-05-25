package com.example.rentalhousemanagementsystem.dto;

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
    private String deductedBy;
    private String remarks;
    private String rentedPropertyID;
}
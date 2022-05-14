package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "keymoney")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class KeyMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;
    private String value;
    private String date;
    private String description;
    private String deductedBy;
    private String remarks;
    private String rentedPropertyID;
}

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
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "deductedBy", referencedColumnName = "username")
    private User deductedBy;

    @ManyToOne
    @JoinColumn(name = "rentedPropertyID", referencedColumnName = "recordId")
    private RentedProperty rentedPropertyID;


}

package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sublet")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sublet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subletRecordID;
    private String subletNIC;
    private String name;
    private String subleaseStartDate;
    private String subleaseEndDate;
    private String subletIDPhotos;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "subleasedProperty", referencedColumnName = "recordId")
    private RentedProperty subleasedProperty;
}

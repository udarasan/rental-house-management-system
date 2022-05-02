package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "defect")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int defectId;
    private String reportedBy; // User NIC
    private String regarding; // Property ID
    private String date;
    private String description;
    private String photos;
    private String adminComponentSignOff;
    private String adminRemarks;
    private String fixConfirmation;
    private String remarks;


}

package com.example.rentalhousemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DefectDTO {
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

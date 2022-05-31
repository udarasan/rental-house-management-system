package com.example.rentalhousemanagementsystem.dto;

import com.example.rentalhousemanagementsystem.entity.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaintenanceDTO {
    private int appointmentID;
    private String description;
    private Property maintenanceFor;  // PropertyId
    private String scheduleDateTime;
    private String EstimatedTimeFrame;
    private String tenantSignOff;
    private String proofUpload;
    private String remarks;
}

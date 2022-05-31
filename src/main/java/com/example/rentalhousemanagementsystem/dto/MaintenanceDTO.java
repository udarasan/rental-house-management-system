package com.example.rentalhousemanagementsystem.dto;

import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.entity.RentedProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaintenanceDTO {
    private int appointmentID;
    private String description;
    private RentedProperty maintenanceFor;  // PropertyId
    private String scheduleDateTime;
    private String EstimatedTimeFrame;
    private String tenantSignOff;
    private String proofUpload;
    private String remarks;
}

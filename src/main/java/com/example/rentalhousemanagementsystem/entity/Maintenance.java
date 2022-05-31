package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "maintenance")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentID;
    private String description;
    private String scheduleDateTime;
    private String EstimatedTimeFrame;
    private String tenantSignOff;
    private String proofUpload;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "maintenanceFor", referencedColumnName = "recordId")
    private RentedProperty maintenanceFor;

}

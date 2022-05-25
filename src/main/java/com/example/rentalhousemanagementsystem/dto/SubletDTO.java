package com.example.rentalhousemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubletDTO {
    private int subletRecordID;
    private String subletNIC;
    private String name;
    private String subleasedProperty;// (Rented property ID - Extracted from the “Rented Property” table)
    private String subleaseStartDate;
    private String subleaseEndDate;
    private String subletIDPhotos;
    private String remarks;
}

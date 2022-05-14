package com.example.rentalhousemanagementsystem.dto;

import com.example.rentalhousemanagementsystem.entity.Property;
import com.example.rentalhousemanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentedPropertyDTO {
    private Integer recordId;
    private Integer rentedPropertyStatus;
    private String rentalStartDate;
    private String rentalEndDate;
    private String rentalAgreementDocsDescription;
    private String rentalAgreementDocs;
    private String remarks;
    private Property rented_unit_id;
    private User current_tenant_nic;
    private String initialKeyMoney;
    private String currentKeyMoneyBalance;
}

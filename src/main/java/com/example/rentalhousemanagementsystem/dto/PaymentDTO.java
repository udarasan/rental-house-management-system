package com.example.rentalhousemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private Long paymentId;
    private String description;
    private String status;
    private String paymentDate;
    private String paidFor;
    private String paidBy;
    private String amount;
    private String remarks;
}

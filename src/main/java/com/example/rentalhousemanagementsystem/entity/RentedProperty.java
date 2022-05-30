package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rented_property")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentedProperty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;
    private String rentedPropertyStatus;
    private String rentalStartDate;
    private String rentalEndDate;
    private String rentalAgreementDocsDescription;
    private String rentalAgreementDocs;
    private String remarks;
    private String initialKeyMoney;
    private String currentKeyMoneyBalance;

    @ManyToOne
    @JoinColumn(name = "rented_unit_id", referencedColumnName = "unitId")
    private Property rented_unit_id;

    @ManyToOne
    @JoinColumn(name = "current_tenant_nic", referencedColumnName = "username")
    private User current_tenant_nic;

}

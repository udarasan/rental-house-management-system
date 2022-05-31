package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "property")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;
    private String description;
    private String unitAddress;
    private String importantPropertyDocsDesc;
    private String importantDocDownload;
    private String outOfOrderStatus;
    private String remarks;
}

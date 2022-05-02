package com.example.rentalhousemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyDTO {
    private int unitId;
    private String description;
    private String unitAddress;
    private String importantPropertyDocsDesc;
    private String importantDocDownload;
    private String propertyCoverImage;
    private String propertyOtherImages;
    private String outOfOrderStatus;
    private String remarks;
    private String initialKeyMoney;
    private String currentKeyMoneyBalance;
}

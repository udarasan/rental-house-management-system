package com.example.rentalhousemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {

    private Integer id;
    private String messageSubject;
    private String messageBody;
    private String receiverEmail;
    private String date;

}

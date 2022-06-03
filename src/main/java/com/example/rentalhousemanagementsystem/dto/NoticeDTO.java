package com.example.rentalhousemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private int id;
    private String subject;
    private String message;
    private String takeDownNotice;
    private String postedBy;
    private String fileName;
    private String date;
}

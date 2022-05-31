package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notice")
public class Notice {
    @Id
    private int id;
    private String subject;
    private String message;
    private String takeDownNotice;
    private String postedBy;
    private String date;

}

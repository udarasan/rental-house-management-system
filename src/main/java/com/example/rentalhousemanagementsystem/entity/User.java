package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "systemuser")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String roleCode;
    private String address;
    private String username;
    private String status;
    private String phoneNo1;
    private String phoneNo2;
    private String idPhoto;
    private String remarks;
    private String email;
    private String name;


}

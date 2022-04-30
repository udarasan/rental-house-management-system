package com.example.rentalhousemanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @JsonIgnore
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

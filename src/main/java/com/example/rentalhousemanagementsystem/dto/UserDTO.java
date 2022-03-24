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
    private long id;
    private String username;
    private String password;
    private String roleCode;
    private String userLevel;
}

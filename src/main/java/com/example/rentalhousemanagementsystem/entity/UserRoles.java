package com.example.rentalhousemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userrole")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoles {
    @Id
    private String roleCode;
    @Column
    private String accessList;
}

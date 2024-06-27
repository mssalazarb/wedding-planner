package com.planner.wedding.wedding.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private Long id;
    private String fullName;
    private String idNumber;
    private String phone;
    private String email;
    private String address;
}

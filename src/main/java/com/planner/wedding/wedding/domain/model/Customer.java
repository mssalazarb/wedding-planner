package com.planner.wedding.wedding.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.planner.wedding.wedding.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private Long id;
    private Long supplierTypeId;
    private String phone;
    private String email;
    private String highStreet;
    private String sideStreet;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

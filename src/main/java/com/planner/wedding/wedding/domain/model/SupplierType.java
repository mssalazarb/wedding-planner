package com.planner.wedding.wedding.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SupplierType {
    private Long id;
    private String type;
    private String supplierName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
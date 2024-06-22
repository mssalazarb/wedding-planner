package com.planner.wedding.wedding.infrastructure.adapter.out.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierTypeId;
    private String phone;
    private String email;
    private String highStreet;
    private String sideStreet;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

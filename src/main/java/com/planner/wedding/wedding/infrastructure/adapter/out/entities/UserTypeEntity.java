package com.planner.wedding.wedding.infrastructure.adapter.out.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_type")
public class UserTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String relatedTable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

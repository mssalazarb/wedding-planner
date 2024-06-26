package com.planner.wedding.wedding.infrastructure.adapter.out.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer capacity;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

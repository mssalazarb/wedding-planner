package com.planner.wedding.wedding.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Reception {
    private Long id;
    private String title;
    private String phone;
    private String email;
    private String address;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

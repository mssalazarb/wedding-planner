package com.planner.wedding.wedding.domain.model;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Event {
    private Long id;

    @NotNull(message = "The customerId is required.")
    private Long customerId;

    @NotNull(message = "The receptionId is required.")
    private Long receptionId;

    @NotNull(message = "The description is required.")
    @NotEmpty(message = "The description is required.")
    private String description;

    @NotNull(message = "The capacity is required.")
    private Integer capacity;

    @NotNull(message = "The startDate is required.")
    private Timestamp startDate;

    @NotNull(message = "The endDate is required.")
    private Timestamp endDate;
    private String status;
}

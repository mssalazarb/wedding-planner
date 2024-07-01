package com.planner.wedding.wedding.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Event {
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

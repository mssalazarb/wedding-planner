package com.planner.wedding.wedding.domain.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Event {
    //private Long id;
    private Long customerId;
    private Long receptionId;
    private String description;
    private Integer capacity;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;
}

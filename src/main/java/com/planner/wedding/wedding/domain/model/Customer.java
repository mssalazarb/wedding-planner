package com.planner.wedding.wedding.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Customer {
    private Long id;

    @NotNull(message = "The fullName is required.")
    @NotEmpty(message = "The fullName is required.")
    private String fullName;

    @NotNull(message = "The phone is required.")
    @NotEmpty(message = "The phone is required.")
    private String idNumber;

    @NotNull(message = "The phone is required.")
    @NotEmpty(message = "The phone is required.")
    private String phone;

    private String email;
    private String address;
}

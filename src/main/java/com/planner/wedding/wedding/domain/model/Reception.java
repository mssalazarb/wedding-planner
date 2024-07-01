package com.planner.wedding.wedding.domain.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Reception {
    @NotNull(message = "The description is required.")
    @NotEmpty(message = "The description is required.")
    private String title;

    @NotNull(message = "The description is required.")
    @NotEmpty(message = "The description is required.")
    private String phone;

    private String email;
    private String address;
    private BigDecimal price;
}

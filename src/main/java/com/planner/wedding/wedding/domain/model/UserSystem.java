package com.planner.wedding.wedding.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSystem {
    @NotNull(message = "The fullName is required.")
    private Long userTypeId;

    @NotNull(message = "The fullName is required.")
    @NotEmpty(message = "The fullName is required.")
    private String userName;

    @NotNull(message = "The fullName is required.")
    @NotEmpty(message = "The fullName is required.")
    private String password;
}

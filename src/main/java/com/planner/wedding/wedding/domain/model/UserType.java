package com.planner.wedding.wedding.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {
    private Long id;
    private String name;
    private String relatedTable;
}

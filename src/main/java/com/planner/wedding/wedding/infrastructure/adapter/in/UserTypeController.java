package com.planner.wedding.wedding.infrastructure.adapter.in;

import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.domain.ports.in.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user-types")
@RestController
@AllArgsConstructor
public class UserTypeController {
    private final UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserType>> getAll() {
        return ResponseEntity.ok(userTypeService.findAll());
    }
}

package com.planner.wedding.wedding.infrastructure.adapter.in;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.model.UserSystem;
import com.planner.wedding.wedding.domain.ports.in.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserSystem> create(@Valid @RequestBody UserSystem userSystem) {
        return ResponseEntity.ok(userService.create(userSystem));
    }
}

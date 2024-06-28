package com.planner.wedding.wedding.infrastructure.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/receptions")
public class ReceptionController {
    private final ReceptionService receptionService;

    @GetMapping
    public ResponseEntity<List<Reception>> getAll() {
        return ResponseEntity.ok(receptionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Reception> create(@Valid @RequestBody Reception reception) {
        return ResponseEntity.ok(receptionService.create(reception));
    }
}

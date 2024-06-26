package com.planner.wedding.wedding.infrastructure.adapter.in;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/receptions")
public class ReceptionController {
    private final ReceptionService receptionService;

    @GetMapping
    public ResponseEntity<List<Reception>> getAll() {
        return ResponseEntity.ok(receptionService.findAll());
    }
}

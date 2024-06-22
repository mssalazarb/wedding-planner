package com.planner.wedding.wedding.infrastructure.adapter.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planner.wedding.wedding.domain.model.SupplierType;
import com.planner.wedding.wedding.domain.ports.in.SupplierTypeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/supplier-types")
@AllArgsConstructor
public class SupplierTypeController {

    private final SupplierTypeService service;

    @PostMapping
    public ResponseEntity<SupplierType> createSupplierType(@RequestBody SupplierType supplierType) {
        SupplierType created = this.service.createSupplierType(supplierType);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierType> getSupplierTypeById(@PathVariable Long id) {
        SupplierType supplierType = this.service.getSupplierTypeById(id);
        return supplierType != null ? ResponseEntity.ok(supplierType) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierType>> getAllSupplierTypes() {
        List<SupplierType> supplierTypes = this.service.getAllSupplierTypes();
        return ResponseEntity.ok(supplierTypes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierType> updateSupplierType(@PathVariable Long id,
            @RequestBody SupplierType supplierType) {
        supplierType.setId(id);
        SupplierType updated = this.service.updateSupplierType(supplierType);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierType(@PathVariable Long id) {
        this.service.deleteSupplierType(id);
        return ResponseEntity.noContent().build();
    }
}

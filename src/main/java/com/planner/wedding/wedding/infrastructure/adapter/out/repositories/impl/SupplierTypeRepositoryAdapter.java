package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.planner.wedding.wedding.domain.model.SupplierType;
import com.planner.wedding.wedding.domain.ports.out.SupplierTypeRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.SupplierTypeEntity;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.SupplierTypeJpaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SupplierTypeRepositoryAdapter implements SupplierTypeRepository {
    private final SupplierTypeJpaRepository jpaRepository;

    @Override
    public SupplierType save(SupplierType supplierType) {
        SupplierTypeEntity entity = toEntity(supplierType);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public SupplierType findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public List<SupplierType> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private SupplierTypeEntity toEntity(SupplierType supplierType) {
        SupplierTypeEntity entity = new SupplierTypeEntity();
        entity.setId(supplierType.getId());
        entity.setType(supplierType.getType());
        entity.setSupplierName(supplierType.getSupplierName());
        entity.setCreatedAt(supplierType.getCreatedAt());
        entity.setUpdatedAt(supplierType.getUpdatedAt());

        return entity;
    }

    private SupplierType toDomain(SupplierTypeEntity entity) {
        SupplierType supplierType = new SupplierType();
        supplierType.setId(entity.getId());
        supplierType.setType(entity.getType());
        supplierType.setSupplierName(entity.getSupplierName());
        supplierType.setCreatedAt(entity.getCreatedAt());
        supplierType.setUpdatedAt(entity.getUpdatedAt());

        return supplierType;
    }
}

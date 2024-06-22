package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.SupplierTypeEntity;

@Repository
public interface SupplierTypeJpaRepository extends JpaRepository<SupplierTypeEntity, Long> {

}

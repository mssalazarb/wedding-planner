package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}

package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.ReceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionJpaRepository extends JpaRepository<ReceptionEntity, Long> {
}

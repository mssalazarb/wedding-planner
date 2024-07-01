package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends JpaRepository<EventEntity, Long>  {
}

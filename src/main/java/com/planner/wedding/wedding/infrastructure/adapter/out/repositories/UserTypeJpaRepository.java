package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeJpaRepository extends JpaRepository<UserTypeEntity, Long> {
}

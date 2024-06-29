package com.planner.wedding.wedding.infrastructure.adapter.out.repositories;

import com.planner.wedding.wedding.infrastructure.adapter.out.entities.UserSystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<UserSystemEntity, Long> {
    @Query(value = "SELECT * FROM user_system WHERE user_name=?1", nativeQuery = true)
    UserSystemEntity existUser(String userName);
}

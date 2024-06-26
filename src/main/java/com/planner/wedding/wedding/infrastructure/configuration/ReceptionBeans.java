package com.planner.wedding.wedding.infrastructure.configuration;

import com.planner.wedding.wedding.application.ReceptionServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;
import com.planner.wedding.wedding.domain.ports.out.ReceptionRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.ReceptionJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.ReceptionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceptionBeans {
    @Bean
    ReceptionService receptionService(ReceptionJpaRepository receptionJpaRepository) {
        return new ReceptionServiceImpl(this.receptionRepository(receptionJpaRepository));

    }

    @Bean
    ReceptionRepository receptionRepository(ReceptionJpaRepository receptionJpaRepository) {
        return new ReceptionRepositoryAdapter(receptionJpaRepository);
    }
}

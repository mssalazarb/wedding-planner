package com.planner.wedding.wedding.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.planner.wedding.wedding.application.SupplierTypeServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.SupplierTypeService;
import com.planner.wedding.wedding.domain.ports.out.SupplierTypeRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.SupplierTypeJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.SupplierTypeRepositoryAdapter;

@Configuration
public class SupplierTypeBeans {

    @Bean
    SupplierTypeService service(SupplierTypeJpaRepository jpaRepository) {
        return new SupplierTypeServiceImpl(this.repository(jpaRepository));
    }

    @Bean
    SupplierTypeRepository repository(SupplierTypeJpaRepository jpaRepository) {
        return new SupplierTypeRepositoryAdapter(jpaRepository);
    }
}

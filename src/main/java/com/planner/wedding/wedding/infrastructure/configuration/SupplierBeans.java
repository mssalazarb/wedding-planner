package com.planner.wedding.wedding.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.planner.wedding.wedding.application.SupplierServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.SupplierService;
import com.planner.wedding.wedding.domain.ports.out.SupplierRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.SupplierJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.SupplierRepositoryAdapter;

@Configuration
public class SupplierBeans {
    @Bean
    SupplierService supplierService(SupplierJpaRepository jpaRepository) {
        return new SupplierServiceImpl(this.supplierRepository(jpaRepository));
    }

    @Bean
    SupplierRepository supplierRepository(SupplierJpaRepository jpaRepository) {
        return new SupplierRepositoryAdapter(jpaRepository);
    }
}

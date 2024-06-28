package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toCustomer(CustomerEntity customers);

    CustomerEntity toCustomerEntity(Customer customer);
}

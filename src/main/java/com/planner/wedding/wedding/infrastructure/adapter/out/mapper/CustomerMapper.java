package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toCustomer(CustomerEntity customers);
    CustomerEntity toCustomerEntity(Customer customer);
}

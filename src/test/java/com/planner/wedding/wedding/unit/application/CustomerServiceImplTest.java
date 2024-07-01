package com.planner.wedding.wedding.unit.application;

import com.planner.wedding.wedding.application.CustomerServiceImpl;
import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.in.CustomerService;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import com.planner.wedding.wedding.infrastructure.exception.NotFoundException;
import com.planner.wedding.wedding.unit.DataUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CustomerServiceImpl.class})
public class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;


    @Test
    void shouldSuccess_whenCreate() {
        Customer request = DataUtil.buildCustomerRequest();
        Customer result = DataUtil.buildCustomerResponse();

        when(customerRepository.create(any())).thenReturn(result);

        var response = customerService.create(request);

        Assertions.assertThat(response.getFullName()).isEqualTo(result.getFullName());
        Assertions.assertThat(response.getAddress()).isEqualTo(result.getAddress());
        Assertions.assertThat(response.getEmail()).isEqualTo(result.getEmail());
        Assertions.assertThat(response.getPhone()).isEqualTo(result.getPhone());
    }

    @Test
    void shouldSuccess_whenFindAll() {
        List<Customer> list = DataUtil.buildListCustomerResponse();

        when(customerRepository.findAll()).thenReturn(list);

        var response = customerService.findAll();
        Assertions.assertThat((long) response.size()).isEqualTo(1);
    }

    @Test
    void shouldReturnCustomer_whenFindById() {
        List<Customer> list = DataUtil.buildListCustomerResponse();
        Customer result = DataUtil.buildCustomerResponse();

        when(customerRepository.findById(any())).thenReturn(result);

        var response = customerService.findById(1L);

        Assertions.assertThat(response.getFullName()).isEqualTo(result.getFullName());
        Assertions.assertThat(response.getAddress()).isEqualTo(result.getAddress());
        Assertions.assertThat(response.getEmail()).isEqualTo(result.getEmail());
        Assertions.assertThat(response.getPhone()).isEqualTo(result.getPhone());
    }

    @Test
    void shouldReturnError_whenFindById() {
        when(customerRepository.findById(any())).thenReturn(null);
        Throwable exception = assertThrows(NotFoundException.class, () -> {
            customerService.findById(1L);
        });
        assertEquals("No exist customer.", exception.getMessage());
    }
}

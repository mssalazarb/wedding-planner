package com.planner.wedding.wedding.unit.infraestructure.adapter.in;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.in.CustomerService;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerService customerService;

    @Test
    void shouldReturnSuccess_whenCreateEvent() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/customers";
        URI uri = new URI(baseUrl);
        //arrange
        Customer customerRequest = DataUtil.buildCustomerRequest();
        Customer customerResponse = DataUtil.buildCustomerResponse();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> request = new HttpEntity<>(customerRequest, headers);

        when(customerService.create(any(Customer.class))).thenReturn(customerResponse);
        //act
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void shouldSuccess_whenListAllCustomers() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/customers";
        URI uri = new URI(baseUrl);

        //act
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}

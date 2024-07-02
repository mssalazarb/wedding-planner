package com.planner.wedding.wedding.unit.infraestructure.adapter.in;

import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.domain.ports.in.UserTypeService;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTypeControllerTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserTypeService userTypeService;

    @Test
    void shouldReturnSuccess_whenCreate() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/user-types";
        URI uri = new URI(baseUrl);
        //arrange
        List<UserType> result = DataUtil.buildListUserTypeResponse();

        when(userTypeService.findAll()).thenReturn(result);
        //act
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}

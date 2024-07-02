package com.planner.wedding.wedding.unit.infraestructure.adapter.in;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReceptionControllerTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ReceptionService receptionService;

    @Test
    void shouldReturnSuccess_whenCreate() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/receptions";
        URI uri = new URI(baseUrl);
        //arrange
        Reception receptionRequest = DataUtil.buildReceptionRequest();
        Reception receptionResponse = DataUtil.buildReceptionResponse();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reception> request = new HttpEntity<>(receptionRequest, headers);

        when(receptionService.create(any(Reception.class))).thenReturn(receptionResponse);
        //act
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}

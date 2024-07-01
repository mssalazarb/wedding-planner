package com.planner.wedding.wedding.unit.infraestructure.adapter.in;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.ports.in.EventService;
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
class EventControllerTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EventService eventService;

    @Test
    void shouldReturnSuccess_whenCreate() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/events";
        URI uri = new URI(baseUrl);
        //arrange
        Event eventRequest = DataUtil.buildEventRequest();
        Event eventResponse = DataUtil.buildEventResponse();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Event> request = new HttpEntity<>(eventRequest, headers);

        when(eventService.create(any(Event.class))).thenReturn(eventResponse);
        //act
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void shouldReturnError_whenDescriptionIsEmpty() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/wedding-planner/events";
        URI uri = new URI(baseUrl);
        //arrange
        Event eventRequest = DataUtil.buildEventRequest();
        eventRequest.setDescription("");
        Event eventResponse = DataUtil.buildEventResponse();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Event> request = new HttpEntity<>(eventRequest, headers);

        when(eventService.create(any(Event.class))).thenReturn(eventResponse);
        //act
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        //assertion
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}

package com.planner.wedding.wedding.unit.application;

import com.planner.wedding.wedding.application.EventServiceImpl;
import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.ports.in.EventService;
import com.planner.wedding.wedding.domain.ports.out.EventRepository;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {EventServiceImpl.class})
public class EventServiceImplTest {
    @Autowired
    private EventService eventService;
    @MockBean
    private EventRepository eventRepository;

    @Test
    void shouldOk_whenCreateEvent() {
        Event request = DataUtil.buildEventRequest();
        Event result = DataUtil.buildEventResponse();

        when(eventRepository.create(any(Event.class))).thenReturn(result);
        var response = eventService.create(request);

        Assertions.assertEquals(response.getCapacity(), result.getCapacity());
        Assertions.assertEquals(response.getDescription(), result.getDescription());
        Assertions.assertEquals(response.getStatus(), result.getStatus());
        Assertions.assertEquals(response.getCustomerId(), result.getCustomerId());
        Assertions.assertEquals(response.getReceptionId(), result.getReceptionId());
    }
}

package com.planner.wedding.wedding.unit.application;

import com.planner.wedding.wedding.application.ReceptionServiceImpl;
import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;
import com.planner.wedding.wedding.domain.ports.out.ReceptionRepository;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ReceptionServiceImpl.class})
public class ReceptionServiceImplTest {
    @Autowired
    private ReceptionService receptionService;
    @MockBean
    private ReceptionRepository receptionRepository;

    @Test
    void shouldOk_whenCreate() {
        Reception request = new Reception();
        Reception result = new Reception();

        when(receptionRepository.create(any())).thenReturn(result);

        var response = receptionService.create(request);
        Assertions.assertEquals(response.getAddress(), result.getAddress());
        Assertions.assertEquals(response.getEmail(), result.getEmail());
        Assertions.assertEquals(response.getTitle(), result.getTitle());
        Assertions.assertEquals(response.getPhone(), result.getPhone());
    }

    @Test
    void shouldSuccess_whenFindAll() {
        List<Reception> list = DataUtil.buildListReceptionResponse();

        when(receptionRepository.findAll()).thenReturn(list);

        var response = receptionService.findAll();
        Assertions.assertEquals((long) response.size(), 1L);
    }
}

package com.planner.wedding.wedding.unit.application;

import com.planner.wedding.wedding.application.UserTypeServiceImpl;
import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.domain.ports.in.UserTypeService;
import com.planner.wedding.wedding.domain.ports.out.UserTypeRepository;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserTypeServiceImpl.class})
public class UserTypeServiceImplTest {
    @Autowired
    private UserTypeService userTypeService;
    @MockBean
    private UserTypeRepository userTypeRepository;

    @Test
    void shouldOk_whenCreate() {
        List<UserType> result = DataUtil.buildListUserTypeResponse();

        when(userTypeRepository.findAll()).thenReturn(result);
        var response = userTypeService.findAll();

        Assertions.assertEquals(response.get(0).getName(), result.get(0).getName());
        Assertions.assertEquals(response.get(0).getRelatedTable(), result.get(0).getRelatedTable());
    }
}

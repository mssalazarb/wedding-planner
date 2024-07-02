package com.planner.wedding.wedding.unit.application;

import com.planner.wedding.wedding.application.UserServiceImpl;
import com.planner.wedding.wedding.domain.model.UserSystem;
import com.planner.wedding.wedding.domain.ports.in.UserService;
import com.planner.wedding.wedding.domain.ports.out.UserRepository;
import com.planner.wedding.wedding.unit.DataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceImpl.class})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void shouldOk_whenCreate() {
        UserSystem request = DataUtil.buildUserSystemRequest();
        UserSystem result = DataUtil.buildUserSystemResponse();

        when(userRepository.create(any(UserSystem.class))).thenReturn(result);
        var response = userService.create(request);

        Assertions.assertEquals(response.getUserName(), result.getUserName());
        Assertions.assertEquals(response.getUserTypeId(), result.getUserTypeId());
    }

    @Test
    void shouldReturnError_whenAlreadyExistUserName() {
        UserSystem request = DataUtil.buildUserSystemRequest();

        when(userRepository.existUser(anyString())).thenReturn(true);

        Throwable exception = assertThrows(RuntimeException.class, () -> userService.create(request));
        assertEquals("user already exists", exception.getMessage());
    }
}

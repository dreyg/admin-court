package org.drg.controllers;

import org.drg.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserControllerTest REST tests - MockMVC")
public class UserControllerTest {

    @InjectMocks
    UserController employeeController;

    @MockBean
    private UserService userService;

/*    @Test
    @DisplayName("Comprobar que se pueden recuperar todos los usuarios")
    public void getUsersTest() throws Exception{

        Collection<UserResponseDto> fakeUsers = Arrays.asList(new UserResponseDto(new Long(999),"Alberto","Lopez","alopezg","alopezg@gmail.com","1234","calle las adelfas 2D","1","C"));

        when(userService.findAll()).thenReturn(fakeUsers);

        mvc.perform(
                        get("/api/users/")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }*/
}

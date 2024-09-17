package com.example.workintech;

import com.example.workintech.controller.UserController;
import com.example.workintech.entity.User;
import com.example.workintech.entity.Role;
import com.example.workintech.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        User user = User.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password123")
                .role(Role.CUSTOMER)
                .build();

        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\", \"role\": \"CUSTOMER\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = User.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password123")
                .role(Role.CUSTOMER)
                .build();

        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }
}

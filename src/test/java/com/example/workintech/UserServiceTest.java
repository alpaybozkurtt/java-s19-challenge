package com.example.workintech;

import com.example.workintech.entity.User;
import com.example.workintech.entity.Role;
import com.example.workintech.repository.UserRepository;
import com.example.workintech.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = User.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password123")
                .role(Role.CUSTOMER)
                .build();
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.saveUser(user);
        assertNotNull(savedUser);
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals(user.getName(), foundUser.getName());
    }
}

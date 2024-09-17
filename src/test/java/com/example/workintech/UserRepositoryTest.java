package com.example.workintech;

import com.example.workintech.entity.User;
import com.example.workintech.entity.Role;
import com.example.workintech.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password123")
                .role(Role.CUSTOMER)
                .build();

        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindUserById() {
        User user = User.builder()
                .name("Jane Doe")
                .email("jane.doe@example.com")
                .password("password123")
                .role(Role.CUSTOMER)
                .build();

        userRepository.save(user);
        User foundUser = userRepository.findById(user.getId()).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("jane.doe@example.com");
    }
}

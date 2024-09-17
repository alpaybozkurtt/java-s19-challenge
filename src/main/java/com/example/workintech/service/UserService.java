package com.example.workintech.service;

import com.example.workintech.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}

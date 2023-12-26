package com.jio.librarymanagementsystem.service;

import com.jio.librarymanagementsystem.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    void testCreateAndGetUser() {
        User user = new User(null, "Test User");

        User createdUser = userService.createUser(user);
        assertNotNull(createdUser.getId());

        User retrievedUser = userService.getUserById(createdUser.getId());
        assertNotNull(retrievedUser);
        assertEquals(createdUser.getId(), retrievedUser.getId());
        assertEquals("Test User", retrievedUser.getName());
    }

    // Add more tests for updateUser, deleteUser, and other scenarios
}

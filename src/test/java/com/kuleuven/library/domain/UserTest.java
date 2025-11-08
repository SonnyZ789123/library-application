package com.kuleuven.library.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getRole() {
        User user = new User("Alice");

        assertEquals("USER", user.getRole());
    }

    @Test
    void getName() {
        User user = new User("Alice");

        assertEquals("Alice", user.getName());
    }
}
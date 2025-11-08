package com.kuleuven.library.impl;

import com.kuleuven.library.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

class LoggingListenerTest {
    @org.junit.jupiter.api.Test
    void onItemAdded() {
        Book book = new Book("B1", "Design Patterns", 1994, "GoF", 40);

        LoggingListener listener = new LoggingListener();

        // Since the method only prints to console, we will just call it to ensure no exceptions are thrown
        assertDoesNotThrow(() -> listener.onItemAdded(book));
    }
}
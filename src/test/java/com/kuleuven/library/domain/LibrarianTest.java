package com.kuleuven.library.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    @Test
    void getRole() {
        Librarian librarian = new Librarian("Librarian Bob");

        assertEquals("LIBRARIAN", librarian.getRole());
    }

    @Test
    void updateTitle() {
        Librarian librarian = new Librarian("Librarian Bob");
        Book book = new Book("B1", "Design Patterns", 1994, "GoF", 40);

        librarian.updateTitle(book, "New Title");

        assertEquals("New Title", book.getTitle());
    }
}
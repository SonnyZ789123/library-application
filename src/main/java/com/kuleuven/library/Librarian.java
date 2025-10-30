package com.kuleuven.library;

public class Librarian extends User {

    public Librarian(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "LIBRARIAN";
    }

    public void updateTitle(LibraryItem item, String newTitle) {
        // Protected setter from abstract class
        item.setTitle(newTitle);
    }
}

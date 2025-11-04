package com.kuleuven.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryItem book = new Book("B1", "Design Patterns", 1994, "GoF", 40);
        LibraryItem magazine = new Magazine("M1", "Science Weekly", 2023, 42, 12);

        library.addItem(book);
        library.addItem(magazine);

        User member = new Member("Alice");
        Librarian librarian = new Librarian("Bob");

        ((Borrowable) book).borrow(member);
        librarian.updateTitle(book, "Design Patterns (Updated)");

        for (LibraryItem item : library.listItems()) {
            System.out.println(item.getDescription());
        }
    }
}

package com.kuleuven.library;

public class Book extends LibraryItem implements Borrowable {

    private String author;
    private User borrowedBy;

    public Book(String id, String title, int year, String author) {
        super(id, title, year);
        this.author = author;
    }

    @Override
    public String getType() {
        return "BOOK";
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void borrow(User user) {
        if (borrowedBy == null) {
            borrowedBy = user;
        }
    }

    @Override
    public void returnItem() {
        borrowedBy = null;
    }

    @Override
    public boolean isBorrowed() {
        return borrowedBy != null;
    }
}

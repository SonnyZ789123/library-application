package com.kuleuven.library;

public class Book extends LibraryItem implements Borrowable {

    private String author;
    private User borrowedBy;

    public Book(String id, String title, int year, String author, double price) {
        super(id, title, year, price);
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

    @Override
    public double getReducedPrice() {
        double reducedPrice = super.getPrice();
        if (borrowedBy != null && borrowedBy.getRole().equals("MEMBER")) {
            reducedPrice = reducedPrice * 0.9;
        }
        if (borrowedBy != null && borrowedBy.getRole().equals("LIBRARIAN")) {
            reducedPrice = reducedPrice * 0.5;
        }
        if (super.getPrice() > 30) {
            reducedPrice = reducedPrice * 0.95;
        }
        return reducedPrice;
    }
}

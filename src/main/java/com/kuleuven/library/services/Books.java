package com.kuleuven.library.services;

import com.kuleuven.library.datastores.BookDatastore;
import com.kuleuven.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private final BookDatastore bookDatastore;

    public Books(BookDatastore bookDatastore) {
        this.bookDatastore = bookDatastore;
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        return bookDatastore.removeBook(book);
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        bookDatastore.addBook(book);
    }

    public Book getBookById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        return bookDatastore.getBookById(id);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(bookDatastore.getAllBooks());
    }

    public List<Book> getBooksBelowPrice(double price) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookDatastore.getAllBooks()) {
            if (book.getReducedPrice() < price) {
                result.add(book);
            }
        }
        return result;
    }
}

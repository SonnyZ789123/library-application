package com.kuleuven.library.datastores;

import com.kuleuven.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDatastore {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        if (getBookById(book.getId()) != null) {
            throw new IllegalArgumentException("Book with the same ID already exists");
        }

        books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}

package com.kuleuven.library.controllers;

import com.kuleuven.library.domain.Book;
import com.kuleuven.library.domain.Member;
import com.kuleuven.library.services.Books;

import java.util.List;
import java.util.Objects;

public class BookController {

    private final Books booksService;

    public BookController(Books booksService) {
        this.booksService = booksService;
    }

    public Either<ErrorStatus, ?> getAvailableBooks(Member member) {
        if (member == null) {
            return Either.left(ErrorStatus.BAD_REQUEST);
        }

        if (Objects.equals(member.getRole(), "MEMBER")) {
            return Either.left(ErrorStatus.UNAUTHORIZED);
        }

        List<Book> myBooks = booksService.getBooksBelowPrice(member.getCreditScore());

        return Either.right(myBooks);
    }
}

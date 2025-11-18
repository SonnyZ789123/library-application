package com.kuleuven.library;

import com.kuleuven.library.actions.Library;
import com.kuleuven.library.controllers.BookController;
import com.kuleuven.library.datastores.BookDatastore;
import com.kuleuven.library.domain.*;
import com.kuleuven.library.impl.EmailNotifier;
import com.kuleuven.library.impl.LoggingListener;
import com.kuleuven.library.impl.RecommendationService;
import com.kuleuven.library.interfaces.Borrowable;
import com.kuleuven.library.interfaces.Notifier;
import com.kuleuven.library.services.Books;

public class Main {
    public static void main(String[] args) {
        // Inject a Notifier (dynamic dispatch target)
        Notifier notifier = new EmailNotifier();
        Library library = new Library(notifier);

        // Add a logging listener (Observer Pattern)
        library.addListener(new LoggingListener());

        // Create items
        Book book = new Book("B1", "Design Patterns", 1994, "GoF", 40);
        Magazine magazine = new Magazine("M1", "Science Weekly", 2023, 42, 12);

        // Add to library (triggers listener calls)
        library.addItem(book);
        library.addItem(magazine);

        // Users
        User member = new Member("Alice");
        Librarian librarian = new Librarian("Bob");

        // Borrow book + trigger notifier
        book.borrow(member);
        library.notifyItemBorrow(book, member);

        // Update metadata via overridden protected setter
        librarian.updateTitle(book, "Design Patterns (Updated Edition)");

        // Use stream-based search (lambda + comparator dispatch)
        library.searchByTitle("design")
                .forEach(item -> System.out.println(item.getFullDetails()));

        // Demonstrate safe find with exception path
        LibraryItem found = library.safeFindItem("B1");
        System.out.println(found != null ? found.getDescription() : "Not found");

        // Use recommendation service (static singleton + Math.random)
        RecommendationService recommender = RecommendationService.getInstance();
        LibraryItem recommendation = recommender.recommendRandom(library);
        System.out.println("\nRecommended item: " +
                (recommendation != null ? recommendation.getTitle() : "None"));

        // Display all items final info
        for (LibraryItem item : library.listItems()) {
            System.out.println(item.getFullDetails());
        }
    }

    public void bookStoreDemo() {
        // Simple graph for visualizing the control flow graph

        // Fill the bookDatastore
        Book book1 = new Book("B1", "Design Patterns", 1994, "GoF", 40);
        Book book2 = new Book("B2", "Clean Code", 2008, "Robert C. Martin", 35);
        Book book3 = new Book("B3", "The Pragmatic Programmer", 1999, "Andrew Hunt", 30);

        BookDatastore bookDatastore = new BookDatastore();
        bookDatastore.addBook(book1);
        bookDatastore.addBook(book2);
        bookDatastore.addBook(book3);

        Books bookService = new Books(bookDatastore);
        BookController bookController = new BookController(bookService);

        // Create a member
        Member member = new Member("Alice");
        member.setCreditScore(35);

        bookController.getAvailableBooks(member);
    }
}

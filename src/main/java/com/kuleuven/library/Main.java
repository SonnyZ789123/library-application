package com.kuleuven.library;

import com.kuleuven.library.actions.Library;
import com.kuleuven.library.domain.*;
import com.kuleuven.library.impl.EmailNotifier;
import com.kuleuven.library.impl.LoggingListener;
import com.kuleuven.library.impl.RecommendationService;
import com.kuleuven.library.interfaces.Borrowable;
import com.kuleuven.library.interfaces.Notifier;

public class Main {
    public static void main(String[] args) {
        // Inject a Notifier (dynamic dispatch target)
        Notifier notifier = new EmailNotifier();
        Library library = new Library(notifier);

        // Add a logging listener (Observer Pattern)
        library.addListener(new LoggingListener());

        // Create items
        LibraryItem book = new Book("B1", "Design Patterns", 1994, "GoF", 40);
        LibraryItem magazine = new Magazine("M1", "Science Weekly", 2023, 42, 12);

        // Add to library (triggers listener calls)
        library.addItem(book);
        library.addItem(magazine);

        // Users
        User member = new Member("Alice");
        Librarian librarian = new Librarian("Bob");

        // Borrow book + trigger notifier
        ((Borrowable) book).borrow(member);
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
}

package com.kuleuven.library;

public class RecommendationService {
    private static RecommendationService instance;
    private RecommendationService() {}

    public static RecommendationService getInstance() {
        if (instance == null) instance = new RecommendationService();
        return instance;
    }

    public LibraryItem recommendRandom(Library library) {
        var items = library.listItems();
        return items.isEmpty() ? null : items.get((int)(Math.random() * items.size()));
    }
}


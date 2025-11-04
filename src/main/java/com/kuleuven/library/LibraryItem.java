package com.kuleuven.library;

public abstract class LibraryItem {
    private final String id;
    private String title;
    protected int year;
    private double price;

    public LibraryItem(String id, String title, int year, double price) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public final String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public abstract String getType();

    public String getDescription() {
        return getType() + ": " + title + " (" + year + ")";
    }

    public double getPrice() {
        return price;
    }

    public double getReducedPrice() {
        return price;
    }
}

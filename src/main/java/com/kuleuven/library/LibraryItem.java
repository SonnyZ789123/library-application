package com.kuleuven.library;

public abstract class LibraryItem {
    private final String id;
    private String title;
    protected int year;

    public LibraryItem(String id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
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
}

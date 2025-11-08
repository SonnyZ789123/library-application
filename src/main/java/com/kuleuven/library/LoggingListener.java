package com.kuleuven.library;

public class LoggingListener implements LibraryListener {
    public void onItemAdded(LibraryItem item) {
        System.out.println("[LOG] Added: " + item.getTitle());
    }
}

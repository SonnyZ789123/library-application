package com.kuleuven.library.impl;

import com.kuleuven.library.domain.LibraryItem;
import com.kuleuven.library.interfaces.LibraryListener;

public class LoggingListener implements LibraryListener {
    public void onItemAdded(LibraryItem item) {
        System.out.println("[LOG] Added: " + item.getTitle());
    }
}

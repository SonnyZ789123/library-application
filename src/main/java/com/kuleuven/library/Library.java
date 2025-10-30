package com.kuleuven.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> listItems() {
        return items;
    }
}

package com.kuleuven.library.actions;

import com.kuleuven.library.domain.LibraryItem;
import com.kuleuven.library.domain.User;
import com.kuleuven.library.interfaces.LibraryListener;
import com.kuleuven.library.interfaces.Notifier;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final Notifier notifier;
    private final List<LibraryListener> listeners = new ArrayList<>();


    public Library(Notifier notifier) {
        this.notifier = notifier;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        for (LibraryListener l : listeners) {
            l.onItemAdded(item);
        }
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void addListener(LibraryListener l) { listeners.add(l); }

    public void removeListener(LibraryListener l) { listeners.remove(l); }

    public List<LibraryItem> listItems() {
        return items;
    }

    public LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> searchByTitle(String keyword) {
        return items.stream()
                .filter(item -> item.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .toList();
    }

    public LibraryItem safeFindItem(String id) {
        try {
            LibraryItem item = findItemById(id);
            if (item == null) throw new IllegalArgumentException("Item not found: " + id);
            return item;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


    public void notifyItemBorrow(LibraryItem item, User user) {
        notifier.notifyUser(user, "You borrowed: " + item.getTitle());
    }
}

package com.kuleuven.library.actions;

import com.kuleuven.library.domain.LibraryItem;
import com.kuleuven.library.interfaces.LibraryListener;
import com.kuleuven.library.interfaces.Notifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryTest {

    private Library library;
    private Notifier notifier;

    // Minimal stub LibraryItem for testing
    static class TestItem extends LibraryItem {
        public TestItem(String id, String title) {
            super(id, title, 2000, 10);
        }
        @Override
        public String getType() { return "TEST"; }
    }

    @BeforeEach
    void setUp() {
        notifier = mock(Notifier.class);
        library = new Library(notifier);
    }

    @Test
    void addItem() {
        LibraryItem item = new TestItem("1", "Alpha");
        library.addItem(item);
        assertTrue(library.listItems().contains(item));
    }

    @Test
    void removeItem() {
        LibraryItem item = new TestItem("1", "Alpha");
        library.addItem(item);
        library.removeItem(item);
        assertFalse(library.listItems().contains(item));
    }

    @Test
    void addListener() {
        LibraryListener listener = mock(LibraryListener.class);
        library.addListener(listener);

        LibraryItem item = new TestItem("1", "Test");
        library.addItem(item);

        verify(listener, times(1)).onItemAdded(item);
    }

    @Test
    void removeListener() {
        LibraryListener listener = mock(LibraryListener.class);
        library.addListener(listener);
        library.removeListener(listener);

        LibraryItem item = new TestItem("1", "Test");
        library.addItem(item);

        verify(listener, never()).onItemAdded(any());
    }

    @Test
    void listItems() {
        LibraryItem item1 = new TestItem("1", "Alpha");
        LibraryItem item2 = new TestItem("2", "Bravo");
        library.addItem(item1);
        library.addItem(item2);

        List<LibraryItem> items = library.listItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    void findItemById() {
        LibraryItem item = new TestItem("1", "FindMe");
        library.addItem(item);

        LibraryItem found = library.findItemById("1");
        assertEquals(item, found);

        assertNull(library.findItemById("999"));
    }

    @Test
    void searchByTitle() {
        LibraryItem a = new TestItem("1", "Java Programming");
        LibraryItem b = new TestItem("2", "Advanced Java");
        LibraryItem c = new TestItem("3", "Cooking 101");

        library.addItem(a);
        library.addItem(b);
        library.addItem(c);

        List<LibraryItem> result = library.searchByTitle("java");
        assertEquals(2, result.size());
        assertTrue(result.contains(a));
        assertTrue(result.contains(b));
        assertFalse(result.contains(c));

        // Also check alphabetical sorting
        assertEquals("Advanced Java", result.get(0).getTitle());
        assertEquals("Java Programming", result.get(1).getTitle());
    }
}

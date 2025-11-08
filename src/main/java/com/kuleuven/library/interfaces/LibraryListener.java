package com.kuleuven.library.interfaces;

import com.kuleuven.library.domain.LibraryItem;

public interface LibraryListener {
    void onItemAdded(LibraryItem item);
}

package com.kuleuven.library.interfaces;

import com.kuleuven.library.domain.User;

public interface Borrowable {
    void borrow(User user);
    void returnItem();
    boolean isBorrowed();
}

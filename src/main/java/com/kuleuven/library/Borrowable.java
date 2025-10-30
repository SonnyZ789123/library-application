package com.kuleuven.library;

public interface Borrowable {
    void borrow(User user);
    void returnItem();
    boolean isBorrowed();
}

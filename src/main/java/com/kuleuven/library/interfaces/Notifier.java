package com.kuleuven.library.interfaces;

import com.kuleuven.library.domain.User;

public interface Notifier {
    void notifyUser(User user, String message);
}

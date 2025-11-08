package com.kuleuven.library.impl;

import com.kuleuven.library.domain.User;
import com.kuleuven.library.interfaces.Notifier;

public class EmailNotifier implements Notifier {
    public void notifyUser(User user, String message) {
        System.out.println("[EMAIL to " + user.getName() + "] " + message);
    }
}


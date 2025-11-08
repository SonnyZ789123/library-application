package com.kuleuven.library.impl;

import com.kuleuven.library.domain.User;
import com.kuleuven.library.interfaces.Notifier;

public class SMSNotifier implements Notifier {
    public void notifyUser(User user, String message) {
        System.out.println("[SMS to " + user.getName() + "] " + message);
    }
}

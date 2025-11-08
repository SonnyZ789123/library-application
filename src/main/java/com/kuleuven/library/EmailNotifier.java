package com.kuleuven.library;

public class EmailNotifier implements Notifier {
    public void notifyUser(User user, String message) {
        System.out.println("[EMAIL to " + user.getName() + "] " + message);
    }
}


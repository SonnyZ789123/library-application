package com.kuleuven.library;

public class SMSNotifier implements Notifier {
    public void notifyUser(User user, String message) {
        System.out.println("[SMS to " + user.getName() + "] " + message);
    }
}

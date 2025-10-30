package com.kuleuven.library;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getRole() {
        return "USER";
    }

    public String getName() {
        return name;
    }
}

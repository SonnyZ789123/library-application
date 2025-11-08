package com.kuleuven.library.domain;

public class Member extends User {

    public Member(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "MEMBER";
    }
}

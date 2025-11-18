package com.kuleuven.library.domain;

public class Member extends User {

    private double creditScore = 100.0;

    public Member(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "MEMBER";
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }
}

package com.kuleuven.library;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String id, String title, int year, int issueNumber) {
        super(id, title, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "MAGAZINE";
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}

package com.kuleuven.library.domain;

import com.kuleuven.library.domain.LibraryItem;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String id, String title, int year, int issueNumber, double price) {
        super(id, title, year, price);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "MAGAZINE";
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    protected String getFormattedMetadata() {
        return getTitle() + " - Issue #" + issueNumber + " (" + year + ")";
    }
}

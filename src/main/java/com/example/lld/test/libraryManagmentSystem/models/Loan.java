package com.example.lld.test.libraryManagmentSystem.models;

import java.util.UUID;

public class Loan {
    private Member member;
    private BookItem bookItem;
    private final String id;

    public Loan(Member member, BookItem bookItem) {
        this.bookItem = bookItem;
        this.member = member;
        this.id = UUID.randomUUID().toString();
    }

    public String getLoanId() {
        return this.id;
    }
}

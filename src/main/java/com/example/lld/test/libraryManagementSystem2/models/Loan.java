package com.example.lld.test.libraryManagementSystem2.models;

public class Loan {
    private String id;
    private final Member member;
    private final BookItem bookItem;

    public Loan(Member member, BookItem bookItem) {
        this.member = member;
        this.bookItem = bookItem;
    }
}

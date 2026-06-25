package com.example.lld.test.libraryManagementSystem2.models;

import com.example.lld.test.libraryManagementSystem2.states.AvailableState;
import com.example.lld.test.libraryManagementSystem2.states.BookItemState;

import java.util.UUID;

public class BookItem {
    private String id;
    private Book book;
    private BookItemState state;

    public BookItem(Book book) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.state = new AvailableState();
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void updateState(BookItemState bookItemState) {
        this.state = bookItemState;
    }

    public Book getBook() {
        return this.book;
    }

    public void issueBook(Member member, BookItem bookItem) {
        this.state.issueBook(member, bookItem);
    }

    public void returnBook(Member member, BookItem bookItem) {
        this.state.returnBook(member, bookItem);
    }
}

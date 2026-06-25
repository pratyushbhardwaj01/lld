package com.example.lld.test.libraryManagmentSystem.models;

import com.example.lld.test.libraryManagmentSystem.state.AvailableState;
import com.example.lld.test.libraryManagmentSystem.state.BookState;

import java.util.UUID;

public class BookItem {
    private String id;
    private BookState bookState;
    private Book book;

    public BookItem(Book book) {
        this.id = UUID.randomUUID().toString();
        this.bookState = new AvailableState();
        this.book = book;
    }

    public void updateState(BookState newState) {
        this.bookState = newState;
    }

    public void checkoutBook(Member member) {
        bookState.checkoutBook(member, this);
    }

    public void placeHold(Member member) {
        book.addObserver(member);
    }

    public void returnBook(Member member) {
        bookState.returnBook(member,this);
    }

    public Book getBook() {
        return this.book;
    }

    public String getId() {
        return this.id;
    }

}

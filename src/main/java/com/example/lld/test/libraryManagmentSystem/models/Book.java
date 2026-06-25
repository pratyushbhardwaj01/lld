package com.example.lld.test.libraryManagmentSystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
    private final String id;
    private final String author;
    private final List<BookItem> bookItemList;
    private final List<Member> observers;
    private final String name;

    public Book(String author, String name) {
        this.author = author;
        this.id = UUID.randomUUID().toString();
        this.observers = new ArrayList<>();
        this.bookItemList = new ArrayList<>();
        this.name = name;
    }

    public void addObserver(Member member) {
        observers.add(member);
    }

    public void removeObserver(Member member) {
        observers.remove(member);
    }

    public List<BookItem> getBookItemList() {
        return this.bookItemList;
    }

    public String getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void addBookItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }

    public String getName() {
        return this.name;
    }
    public Boolean isObservers() {
        return !this.observers.isEmpty();
    }
    public boolean isMemberRegisteredAsObserver(Member member) {
       return  this.observers.contains(member);

    }
}

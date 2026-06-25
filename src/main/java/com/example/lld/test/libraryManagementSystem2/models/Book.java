package com.example.lld.test.libraryManagementSystem2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
    private String id;
    private String author;
    private String name;
    private List<BookItem> bookItemList;

    public Book(String author, String name) {
        this.author = author;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.bookItemList = new ArrayList<>();
    }

    public void addBookItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }

    public String getId() {
        return this.id;
    }

    public List<BookItem> getBookItemList() {
        return this.bookItemList;
    }

}

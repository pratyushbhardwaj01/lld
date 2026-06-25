package com.example.lld.test.libraryManagementSystem2;

import com.example.lld.test.libraryManagementSystem2.models.Book;
import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Member;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagementSystem {
    private static LibraryManagementSystem libraryManagementSystem;
    private Map<String, Member> membersMap;
    private Map<String, Book> catalog;
    private Map<String, BookItem> bookItemsMap;

    private LibraryManagementSystem() {
        this.membersMap = new HashMap<>();
        this.catalog = new HashMap<>();
        this.bookItemsMap = new HashMap<>();
    }

    public synchronized static LibraryManagementSystem getLibraryManagementSystemInstance() {
        if (libraryManagementSystem == null) {
            libraryManagementSystem = new LibraryManagementSystem();
        }
        return libraryManagementSystem;
    }

    public synchronized Member addMember(String name) {
        Member member = new Member(name);
        this.membersMap.put(member.getId(), member);
        System.out.println("The member name : " + member.getName() + " is added successfully");
        return member;
    }

    public synchronized Book addBook(String author, String name, int copies) {
        Book book = new Book(author, name);
        for (int i = 0; i < copies; i++) {
            BookItem bookItem = new BookItem(book);
            book.addBookItem(bookItem);
            this.bookItemsMap.put(bookItem.getId(), bookItem);
        }
        this.catalog.put(book.getId(), book);
        return book;
    }

    public synchronized void  issueBook(String memberId, String bookItemId) {
        Member member = this.membersMap.get(memberId);
        BookItem bookItem = this.bookItemsMap.get(bookItemId);
        if (member == null || bookItem == null) {
            System.out.println("Invalid member-id  or book-item-id");
            return;
        }
        bookItem.issueBook(member, bookItem);
    }

    public synchronized void returnBook(String memberId, String bookItemId) {
        Member member = this.membersMap.get(memberId);
        BookItem bookItem = this.bookItemsMap.get(bookItemId);
        if (member == null || bookItem == null) {
            System.out.println("Invalid member-id  or book-item-id");
            return;
        }
        bookItem.returnBook(member, bookItem);
    }
}

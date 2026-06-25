package com.example.lld.test.libraryManagmentSystem.services;

import com.example.lld.test.libraryManagmentSystem.models.Book;
import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Member;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagmentService {
    private Map<String, Book> catalogMap;
    private Map<String, BookItem> itemsMap;
    private static LibraryManagmentService libraryManagmentService;
    private Map<String, Member> memberMap;

    private LibraryManagmentService() {
        this.catalogMap = new HashMap<>();
        this.itemsMap = new HashMap<>();
        this.memberMap = new HashMap<>();
    }

    public static synchronized LibraryManagmentService getLibraryManagementServiceInstance() {
        if (libraryManagmentService == null) {
            libraryManagmentService = new LibraryManagmentService();
        }
        return libraryManagmentService;
    }

    public Member addMember(String name) {
        Member member = new Member(name);
        memberMap.put(member.getId(), member);
        return member;
    }

    public Book addBook(String name, String author, int copies) {
        Book book = new Book(author, name);
        catalogMap.put(book.getId(), book);
        for (int i = 0; i < copies; i++) {
            BookItem bookItem = new BookItem(book);
            itemsMap.put(bookItem.getId(), bookItem);
            book.addBookItem(bookItem);
        }
        return book;
    }

    public void checkoutBook(String bookItemId, String memberId) {
        BookItem bookItem = itemsMap.get(bookItemId);
        Member member = memberMap.get(memberId);
        if (bookItem == null || member == null) {
            System.out.println("Either the book item id or member id is not correct");
            return;
        }
        bookItem.checkoutBook(member);
    }

    public void returnBook(String memberId, String itemId) {
        BookItem bookItem = itemsMap.get(itemId);
        Member member = memberMap.get(memberId);
        if (bookItem == null || member == null) {
            System.out.println("Either the book item id or member id is not correct");
            return;
        }
        bookItem.returnBook(member);
    }

    public void addHold(String memberId, String bookItemId) {
        BookItem bookItem = itemsMap.get(bookItemId);
        Member member = memberMap.get(memberId);
        if (bookItem == null || member == null) {
            System.out.println("Either the book item id or member id is not correct");
            return;
        }
        bookItem.placeHold(member);
    }

    public void printCatalog() {
        System.out.println("------------------Library Catalog-------------------");
        for (Map.Entry<String, Book> entry : catalogMap.entrySet()) {
            String key = entry.getKey();
            Book book = entry.getValue();
            for (BookItem bookItem : book.getBookItemList()) {
                System.out.println("BookItemId: " + bookItem.getId() + " bookName: " + book.getName());
            }
        }
    }

    public void printMembers() {
        System.out.println("---------------- Members -----------------------------");
        for (Map.Entry<String, Member> entry : memberMap.entrySet()) {
            System.out.println("memberId: " + entry.getValue().getId() + " name: " + entry.getValue().getName());
        }
    }
}

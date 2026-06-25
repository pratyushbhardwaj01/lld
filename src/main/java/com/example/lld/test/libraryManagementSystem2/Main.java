package com.example.lld.test.libraryManagementSystem2;

import com.example.lld.test.libraryManagementSystem2.models.Book;
import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Member;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = LibraryManagementSystem.getLibraryManagementSystemInstance();
        Member member1 = libraryManagementSystem.addMember("Test-User-1");
        Member member2 = libraryManagementSystem.addMember("Test-User-2");
        Book book = libraryManagementSystem.addBook("Ravinder Singh", "I too had a love story", 1);
        BookItem b11 = book.getBookItemList().getFirst();
        String b11Id = b11.getId();
        String member1Id = member1.getId();
        String member2Id = member2.getId();
        libraryManagementSystem.issueBook(member1Id, b11Id);
        libraryManagementSystem.issueBook(member2Id, b11Id);
    }
}

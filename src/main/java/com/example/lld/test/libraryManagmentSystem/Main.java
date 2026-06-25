package com.example.lld.test.libraryManagmentSystem;

import com.example.lld.test.libraryManagmentSystem.models.Book;
import com.example.lld.test.libraryManagmentSystem.models.Member;
import com.example.lld.test.libraryManagmentSystem.services.LibraryManagmentService;

public class Main {
    public static void main(String[] args) {
        LibraryManagmentService libraryManagmentService = LibraryManagmentService.getLibraryManagementServiceInstance();
        Member member = libraryManagmentService.addMember("Pratyush Bhardwaj");
        Book book1 = libraryManagmentService.addBook("I too had a love story", "Ravinder Singh", 5);
        Book book2 = libraryManagmentService.addBook("you only lived once", "Arun kumar", 2);
        libraryManagmentService.printCatalog();
        libraryManagmentService.printMembers();
        libraryManagmentService.checkoutBook(book1.getBookItemList().get(0).getId(), member.getId());


    }
}

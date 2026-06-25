package com.example.lld.test.libraryManagmentSystem.state;

import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Loan;
import com.example.lld.test.libraryManagmentSystem.models.Member;
import com.example.lld.test.libraryManagmentSystem.services.TransactionService;

public class AvailableState implements BookState {
    @Override
    public void checkoutBook(Member member, BookItem bookItem) {
        Loan loan = new Loan(member, bookItem);
        TransactionService.getTransactionServiceInstance().addLoan(member, bookItem);
    }
    @Override
    public void returnBook(Member member, BookItem bookItem) {
        System.out.println("The book item id : "  + bookItem.getId() + " is already in available state");
    }
    @Override
    public void placeHold(Member member, BookItem bookItem) {
        System.out.println("The book item id : " + bookItem.getId() + " is already in available state");
    }
}

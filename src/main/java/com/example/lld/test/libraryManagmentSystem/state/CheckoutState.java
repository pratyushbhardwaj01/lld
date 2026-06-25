package com.example.lld.test.libraryManagmentSystem.state;

import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Member;
import com.example.lld.test.libraryManagmentSystem.services.TransactionService;

public class CheckoutState implements BookState {
    @Override
    public void checkoutBook(Member member, BookItem bookItem) {
        System.out.println("The bookItem id " + bookItem.getId() + " is already checked out....");
    }

    @Override
    public void placeHold(Member member, BookItem bookItem) {
        System.out.println("The observer name: " + member.getName() + " is added as an observer for item id: " + bookItem.getId());
        bookItem.getBook().addObserver(member);
    }

    @Override
    public void returnBook(Member member, BookItem bookItem) {
        TransactionService.getTransactionServiceInstance().endLoan(bookItem, member);
        bookItem.updateState(new OnHoldState());
    }
}

package com.example.lld.test.libraryManagmentSystem.state;

import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Member;
import com.example.lld.test.libraryManagmentSystem.services.TransactionService;

public class OnHoldState implements BookState {
    @Override
    public void checkoutBook(Member member, BookItem bookItem) {
        if (bookItem.getBook().isObservers()) {
            if (bookItem.getBook().isMemberRegisteredAsObserver(member)) {
                TransactionService.getTransactionServiceInstance().addLoan(member, bookItem);
                bookItem.updateState(new CheckoutState());
            } else {
                System.out.println("Already other members has shown interest in this book item id " + bookItem.getId());
            }

        } else {
            TransactionService.getTransactionServiceInstance().addLoan(member, bookItem);
            bookItem.updateState(new CheckoutState());
        }

    }

    @Override
    public void returnBook(Member member, BookItem bookItem) {
        System.out.println("The book is in hold state so can perform this action " + bookItem.getId());
    }

    @Override
    public void placeHold(Member member, BookItem bookItem) {
        System.out.println("The book item id is already in hold state " + bookItem.getId());
    }
}

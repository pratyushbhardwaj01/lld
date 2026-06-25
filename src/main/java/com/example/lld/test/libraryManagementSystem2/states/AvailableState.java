package com.example.lld.test.libraryManagementSystem2.states;

import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Member;
import com.example.lld.test.libraryManagementSystem2.services.TransactionService;

public class AvailableState implements BookItemState {
    @Override
    public void issueBook(Member member, BookItem bookItem) {
        TransactionService.getTransactionServiceInstance().createLoan(member, bookItem);
        bookItem.updateState(new CheckoutState());
        System.out.println("The book item id " + bookItem.getId() + "issued successfully to member-id " + member.getId());
    }

    @Override
    public void returnBook(Member member, BookItem bookItem) {
        System.out.println("The book item is in available state so cannot return it");
    }

}

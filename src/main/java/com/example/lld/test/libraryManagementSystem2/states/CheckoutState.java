package com.example.lld.test.libraryManagementSystem2.states;

import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Member;
import com.example.lld.test.libraryManagementSystem2.services.TransactionService;

public class CheckoutState implements BookItemState {
    @Override
    public void issueBook(Member member, BookItem bookItem) {
        System.out.println("The book item is already in check out state so cannot issue this item");
    }

    @Override
    public void returnBook(Member member, BookItem bookItem) {
        TransactionService.getTransactionServiceInstance().removeLoan(member, bookItem);
        bookItem.updateState(new AvailableState());
        System.out.println("The book item id " + bookItem.getId() + "returned successfully from member-id " + member.getId());
    }
}

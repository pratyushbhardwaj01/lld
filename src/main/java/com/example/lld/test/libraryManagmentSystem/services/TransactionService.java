package com.example.lld.test.libraryManagmentSystem.services;

import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Loan;
import com.example.lld.test.libraryManagmentSystem.models.Member;

import java.util.HashMap;
import java.util.Map;

public class TransactionService {
    private final Map<String, Loan> loansMap;
    private static TransactionService transactionService;

    private TransactionService() {
        this.loansMap = new HashMap<>();
    }

    public static synchronized TransactionService getTransactionServiceInstance() {
        if (transactionService == null) {
            transactionService = new TransactionService();
        }
        return transactionService;
    }

    public void addLoan(Member member, BookItem bookItem) {
        if (loansMap.get(bookItem.getId()) != null) {
            System.out.println("The book item id: " + bookItem.getId() + " is already in a loan");
            return;
        }
        loansMap.put(bookItem.getId(), new Loan(member, bookItem));
        System.out.println("The load is created for bookItem id; " + bookItem.getId() + " and member name is " + member.getName());
    }

    public void endLoan(BookItem bookItem, Member member) {
        loansMap.remove(bookItem.getId());
        System.out.println("The loan ended for bookItem Id: " + bookItem.getId() + " and member name is " + member.getName());

    }

}

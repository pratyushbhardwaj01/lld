package com.example.lld.test.libraryManagementSystem2.services;

import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Loan;
import com.example.lld.test.libraryManagementSystem2.models.Member;

import java.util.HashMap;
import java.util.Map;

public class TransactionService {
    private static TransactionService transactionService;
    Map<String, Loan>loanMap;

    private TransactionService() {
        this.loanMap = new HashMap<>();
    };

    public  synchronized static TransactionService getTransactionServiceInstance() {
        if(transactionService == null) {
            transactionService = new TransactionService();
        }
        return transactionService;
    }
    public  void createLoan(Member member, BookItem bookItem) {
        if(loanMap.get(bookItem.getId()) != null) {
            System.out.println("The book item is already issued to some other person...");
            return;
        }
        Loan loan = new Loan(member, bookItem);
        loanMap.put(bookItem.getId(), loan);;
    }
    public void removeLoan(Member member, BookItem bookItem) {
        if(loanMap.get(bookItem.getId()) == null) {
            System.out.println("The book item is already returned please check");
            return;
        }
        loanMap.remove(bookItem.getId());
    }
}

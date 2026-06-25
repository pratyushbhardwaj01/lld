package com.example.lld.test.libraryManagementSystem2.states;

import com.example.lld.test.libraryManagementSystem2.models.BookItem;
import com.example.lld.test.libraryManagementSystem2.models.Member;

public interface BookItemState {
    public void issueBook(Member member, BookItem bookItem);
    public void returnBook(Member member, BookItem bookItem);
}

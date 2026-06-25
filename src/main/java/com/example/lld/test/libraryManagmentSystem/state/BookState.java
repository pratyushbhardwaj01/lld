package com.example.lld.test.libraryManagmentSystem.state;

import com.example.lld.test.libraryManagmentSystem.models.BookItem;
import com.example.lld.test.libraryManagmentSystem.models.Member;

public interface BookState {
    public void checkoutBook(Member member, BookItem bookItem);
    public void placeHold(Member member, BookItem bookItem);
    public void returnBook(Member member, BookItem bookItem);
}

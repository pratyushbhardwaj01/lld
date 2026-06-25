package com.example.lld.test.libraryManagmentSystem.models;

import java.util.UUID;

public class Member {
    private String id;
    private String name;

    public Member(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }

}

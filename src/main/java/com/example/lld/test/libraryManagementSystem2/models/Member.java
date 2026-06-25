package com.example.lld.test.libraryManagementSystem2.models;

import java.util.UUID;

public class Member {
    private String id;
    private final String name;

    public Member(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
}

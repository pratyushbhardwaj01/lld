package com.example.lld.template.splitwise.models;

import java.util.List;
import java.util.UUID;

public class Group {
    private final String id;
    private final String name;
    private final List<User> members;

    public Group(String name, List<User> members) {
        this.members = members;
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getGroupId() {
        return this.id;
    }

    public String getGroupName() {
        return this.name;
    }

    public List<User> getMembers() {
        return this.members;
    }
}

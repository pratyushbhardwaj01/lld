package com.example.lld.template.splitwise.models;

import java.util.List;
import java.util.UUID;

public class Group {
    private final String groupId;
    private final String name;
    private final List<User> members;

    public Group(String name, List<User> members) {
        this.name = name;
        this.groupId = UUID.randomUUID().toString();
        this.members = members;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.name;
    }

    public List<User> getMembers() {
        return this.members;
    }
}

package com.example.lld.designpatterns.creational;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Shape {
    public void setColor(String color);

    public Shape getClone();

    public void print();
}

class Rectangle implements Shape {
    private int length;
    private int width;
    private List<String> tags;
    private String color;

    public Rectangle(int length, int width, List<String> tags, String color) {
        this.length = length;
        this.width = width;
        this.tags = new ArrayList<>(tags);
        this.color = color;
    }

    private Rectangle(Rectangle other) {
        this.length = other.length;
        this.width = other.width;
        this.tags = new ArrayList<>(other.tags);
        this.color = other.color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Shape getClone() {
        return new Rectangle(this);
    }

    @Override
    public void print() {
        System.out.println(color + " Rectangle [" + length + "x" + width + "] tags=" + tags);

    }
}

class ShapeRegistry {
    private final static Map<String, Shape> registry = new HashMap<>();

    static {
        registry.put("green", new Rectangle(101, 50, List.of("Tag1", "Tag2"), "green"));
        registry.put("orange", new Rectangle(101, 50, List.of("Tag1", "Tag2"), "orange"));
    }

    public static Shape get(String key) {
        Shape prototype = registry.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("The specified is not found");
        }
        return prototype.getClone();
    }
}


public class PrototypeDesignPattern {
    public static void main(String[] args) {
        Shape s1 = ShapeRegistry.get("green");
        Shape s2 = ShapeRegistry.get("green");
        s2.setColor("red");
        s1.print();
        s2.print();

    }
}
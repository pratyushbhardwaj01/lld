package com.example.lld.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Visitor {
    public void visit(Circle circle);

    public void visit(Triangle triangle);

    public void visit(Square square);
}

interface Element {
    public void accept(Visitor visitor);
}

class Circle implements Element {
    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Triangle implements Element {
    private final int height;
    private final int base;

    Triangle(int height, int base) {
        this.base = base;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getBase() {
        return this.base;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Element {
    private final int side;

    Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class TotalAreaCalculator implements Visitor {
    private int totalArea = 0;

    @Override
    public void visit(Circle c) {
        totalArea += (int) (3.14 * Math.pow(c.getRadius(), 2));
    }

    @Override
    public void visit(Triangle t) {
        totalArea += (t.getBase() * t.getHeight()) / 2;

    }

    @Override
    public void visit(Square s) {
        totalArea += (int) Math.pow(s.getSide(), 2);
    }

    public void printTotalArea() {
        System.out.println("TotalArea: " + totalArea);
    }


}

public class VisitorDesignPattern {

    public static void main(String[] args) {
        Circle c = new Circle(4);
        Triangle t = new Triangle(3, 4);
        Square s = new Square(5);
        List<Element> elementList = new ArrayList<>(List.of(c, t, s));
        TotalAreaCalculator areaCalculator = new TotalAreaCalculator();
        for (Element e : elementList) {
            e.accept(areaCalculator);
        }
        areaCalculator.printTotalArea();
    }
}

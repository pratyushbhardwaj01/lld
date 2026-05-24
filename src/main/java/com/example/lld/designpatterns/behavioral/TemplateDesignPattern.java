package com.example.lld.designpatterns.behavioral;

abstract class Template {
    public void boil() {
        System.out.println("Boil water");
    }

    public void add() {
    }

    public void pour() {
        System.out.println("Pour the drink to the cup");
    }

    public void makeDrink() {
        boil();
        add();
        pour();
    }
}

class Coffee extends Template {
    @Override
    public void add() {
        System.out.println("pour coffee to the hot water");
    }
}

class Tea extends Template {
    @Override
    public void add() {
        System.out.println("pour milk to the hot water");
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args) {
        Coffee c = new Coffee();
        Tea t = new Tea();
        c.makeDrink();
        t.makeDrink();
    }

}

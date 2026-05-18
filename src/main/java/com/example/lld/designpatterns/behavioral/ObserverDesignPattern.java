package com.example.lld.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}

interface Observer {
    void update(float temperature, float humidity);

}

class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    public void setMeasurments(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

class WeatherDisplay implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions " + "temperature: " + temperature + " humidity " + humidity);
    }
}
public  class ObserverDesignPattern {
public static  void main(String[] args) {
    WeatherStation w1 = new WeatherStation();
    WeatherDisplay d1 = new WeatherDisplay();
    w1.addObserver(d1);
    w1.setMeasurments(101, 24);
}
}


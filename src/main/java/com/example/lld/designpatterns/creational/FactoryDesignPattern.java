package com.example.lld.designpatterns.creational;

abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {

    @Override
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    @Override
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

class TwoWheelerFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

class Client {
    private Vehicle vehicle;

    public Client(VehicleFactory factory) {
        this.vehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

class FactoryDesignPattern {
    public static void main(String[] args) {
        TwoWheelerFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();
    }

}



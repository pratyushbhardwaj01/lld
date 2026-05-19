package com.example.lld.designpatterns.behavioral;

interface BaseState {
    public void handleRequest();
}
abstract class VendingMachineBaseState implements BaseState {
    protected VendingMachine vendingMachine;
    public VendingMachineBaseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;

    }
}

class VendingMachineReadyState extends VendingMachineBaseState {
    public VendingMachineReadyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle Ready state");
         vendingMachine.updateState(new VendingMachineProductSelectionState(vendingMachine));
    }
}

class VendingMachineProductSelectionState extends VendingMachineBaseState {
    public VendingMachineProductSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle Product selection state");
        vendingMachine.updateState(new VendingMachinePaymentProcessingState(vendingMachine));
    }
}

class VendingMachinePaymentProcessingState extends VendingMachineBaseState {
    public VendingMachinePaymentProcessingState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle payment processing state");
        vendingMachine.updateState(new VendingMachineOutOfStockState(vendingMachine));
    }
}

class VendingMachineOutOfStockState extends VendingMachineBaseState {
    public VendingMachineOutOfStockState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle out of stock state");
    }
}

class VendingMachine {
    private BaseState baseState;

    public VendingMachine() {
        this.baseState = new VendingMachineReadyState(this);
    }

    public void updateState(BaseState baseState) {
        this.baseState = baseState;

    }

    public void handleRequest() {
        this.baseState.handleRequest();
    }
}

public class StateDesignPattern {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.handleRequest();
        vendingMachine.handleRequest();
        vendingMachine.handleRequest();
        vendingMachine.handleRequest();

    }
}

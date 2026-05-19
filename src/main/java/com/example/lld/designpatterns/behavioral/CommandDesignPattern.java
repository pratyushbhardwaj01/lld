package com.example.lld.designpatterns.behavioral;

interface Command {
    void execute();
}

interface Device {
    void turnOn();

    void turnOff();
}

class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo turned on..");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo turned off..");
    }

    public void adjustVolume() {
        System.out.println("Stereo volume adjusted..");
    }
}

class Tv implements Device {
    @Override
    public void turnOn() {
        System.out.println("Tv turned on..");
    }

    @Override
    public void turnOff() {
        System.out.println("Tv turned off..");
    }

    public void changeChannel() {
        System.out.println("Tv channel changed");
    }
}



class TurnOnCommand implements Command {
    private final Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}



class ChangeTvChannel implements Command {
    private Tv tv;

    public ChangeTvChannel(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Command not found");
        }
    }
}

public class CommandDesignPattern {
    public static void main(String[] args) {
        Tv tv = new Tv();
        Stereo stereo = new Stereo();
        Command command1 = new TurnOnCommand(tv);
        Command command2 = new TurnOnCommand(stereo);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(command1);
        remoteControl.pressButton();
        remoteControl.setCommand(command2);
        remoteControl.pressButton();

    }
}

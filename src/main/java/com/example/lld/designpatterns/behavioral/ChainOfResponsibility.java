package com.example.lld.designpatterns.behavioral;

interface Handler {
     void handleRequest(UserRequest request);

     Handler setNextHandler(Handler handler);
}

abstract class BaseHandler implements Handler {
    private Handler nextHandler;

    @Override
    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
    protected void delegate(UserRequest request) {
        if(nextHandler != null) {
            nextHandler.handleRequest(request);
        }
        else {
            throw new IllegalStateException("No handler found to handle the request");
        }
    }
}

class UserRequest {
    private int id;

    public UserRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

class Manager extends BaseHandler {

    @Override
    public void handleRequest(UserRequest request) {
        int userRequestId = request.getId();
        if (userRequestId >= 0 && userRequestId < 10) {
            System.out.println("Manager handle this user request");
        } else {
            delegate(request);
        }
    }
}

class SeniorManager extends BaseHandler {
    @Override
    public void handleRequest(UserRequest request) {
        int userRequestId = request.getId();
        if (userRequestId >= 10 && userRequestId < 20) {
            System.out.println("Senior Manager handles the request");
        } else {
            delegate(request);
        }
    }
}

class Director extends BaseHandler {
    @Override
    public void handleRequest(UserRequest request) {
        int requestId = request.getId();
        if (requestId >= 20 && requestId < 30) {
            System.out.println("Director handles the request");
        } else {
            delegate(request);
        }
    }
}

public class ChainOfResponsibility {

    public static void main(String[] args) {
        BaseHandler manager = new Manager();
        BaseHandler seniorManager = new SeniorManager();
        BaseHandler director = new Director();
        manager.setNextHandler(seniorManager).setNextHandler(director);
        int[] testIds = { 0, 9, 10, 19, 20, 29 };
        for (int id : testIds) {
            manager.handleRequest(new UserRequest(id));
        }
    }

}

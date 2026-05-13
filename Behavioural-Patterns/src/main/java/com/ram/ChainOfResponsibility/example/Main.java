package com.ram.ChainOfResponsibility.example;

// components
/*
    1) Handler interface
    2) ConcreteHandler objects
    3) Client
*/

// Priority ENUM
enum Priority{
    BASIC,
    INTERMEDIATE,
    CRITICAL
}


// Request Object
class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority(){
        return priority;
    }
}


// 1) Handler Interface
interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}

// 2) ConcreteHandlers Object

class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request){
        if(request.getPriority() == Priority.BASIC){
            System.out.println("Level 1 Support handled the request.");
        }else{
            nextHandler.handleRequest(request);
        }
    }
}

class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request){
        if(request.getPriority() == Priority.INTERMEDIATE){
            System.out.println("Level 2 Support handled the request.");
        }else{
            nextHandler.handleRequest(request);
        }
    }
}

class Level3SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request){
        if(request.getPriority() == Priority.CRITICAL){
            System.out.println("Level 3 Support handled the request.");
        }else{
            nextHandler.handleRequest(request);
        }
    }
}

// 3) client
public class Main {
    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);
    }
}
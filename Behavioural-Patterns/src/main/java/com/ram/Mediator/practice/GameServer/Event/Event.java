package com.ram.Mediator.practice.GameServer.Event;

import com.ram.Mediator.practice.GameServer.Colleague.Position;

public class Event {
    private final String type;
    private final String message;
    private final Position position;

    public Event(String type, String message) {
        this(type, message, null);
    }

    public Event(String type, String message, Position position) {
        this.type = type;
        this.message = message;
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Position getPosition() {
        return position;
    }
}
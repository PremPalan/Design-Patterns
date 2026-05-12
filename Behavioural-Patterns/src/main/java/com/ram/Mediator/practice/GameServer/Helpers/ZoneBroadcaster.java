package com.ram.Mediator.practice.GameServer.Helpers;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Colleague.Position;
import com.ram.Mediator.practice.GameServer.Event.Event;

import java.util.List;

public class ZoneBroadcaster {
    private static final int BROADCAST_RADIUS = 10;

    public void broadcastNearby(Event event, Position origin, List<Player> players) {
        if (event == null || origin == null || players == null) {
            return;
        }

        for (Player player : players) {
            Position p = player.getPosition();
            if (p != null && distance(origin, p) <= BROADCAST_RADIUS) {
                player.receiveEvent(event);
            }
        }
    }

    private double distance(Position a, Position b) {
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }
}
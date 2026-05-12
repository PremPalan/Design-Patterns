package com.ram.Mediator.practice.GameServer.Mediator;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Event.Event;

public interface GameMediator {
    public void attack(Player attacker, Player Target);
    public void trade(Player sender, Player receiver);
    public void sendTeamRequest(Player sender, Player receiver);
    public void broadcastEvent(Event event);
}

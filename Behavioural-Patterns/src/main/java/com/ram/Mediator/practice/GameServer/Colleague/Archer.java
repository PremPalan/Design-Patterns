package com.ram.Mediator.practice.GameServer.Colleague;

import com.ram.Mediator.practice.GameServer.Mediator.GameMediator;

public class Archer extends Player{
    public Archer(int playerId, String username, GameMediator server, Position position) {
        super(playerId, username, server, position);
    }

    @Override
    public void sendAttack(Player target) {
        getServer().attack(this, target);
    }

    @Override
    public void sendTradeRequest(Player target) {
        getServer().trade(this, target);
    }

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public int getRange() {
        return 7;
    }
}
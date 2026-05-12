package com.ram.Mediator.practice.GameServer.Colleague;

import com.ram.Mediator.practice.GameServer.Mediator.GameMediator;

public class Warrior extends Player{
    public Warrior(int playerId, String username, GameMediator server, Position position) {
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
        return 20;
    }

    @Override
    public int getRange() {
        return 3;
    }
}
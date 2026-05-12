package com.ram.Mediator.practice.GameServer.Helpers;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

public class RuleEngine {
    public boolean validateDistance(Player attacker, Player target){
        return distance(attacker.getPosition().getX(), attacker.getPosition().getY(),
        target.getPosition().getX(), target.getPosition().getY()) <= attacker.getRange();
    }

    public float distance(int x1, int y1, int x2, int y2){
        return (float) Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
    }

    public boolean validateHealth(Player player){
        if(player.getHealth() <= 0){
            return true;
        }
        return false;
    }

    public boolean validateCooldown(Player player){
        return false;
    }
}

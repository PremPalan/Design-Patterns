package com.ram.Mediator.practice.GameServer.Helpers;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

public class CombatManager {
    private final RuleEngine ruleEngine;

    public CombatManager(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void processAttack(Player attacker, Player target){
       if(ruleEngine.validateDistance(attacker, target)){
           target.receiveDamage(attacker);
           if(ruleEngine.validateHealth(target)){
               target.setDead(true);
           }
       }else {
           System.out.println("Target Not in Range.....");
       }
   }
}

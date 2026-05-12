package com.ram.Mediator.practice.GameServer.Helpers;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Helpers.Match.Match;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatchMakingService {

    private Queue<Player> queue = new LinkedList<>();

    public void enqueue(Player player){
        queue.add(player);
    }

    public void createMatch(){
        if(queue.size() < 6){
            System.out.println("Waiting for more players...");
            return;
        }

        Match match = new Match();

        for(int i = 0; i < 6; i++){
            Player p1 = queue.poll();
            if(p1 != null){
                match.addPlayer(p1);
            }
        }

        balanceTeams(match);
        System.out.println("Match created...");
    }

    public void balanceTeams(Match match){
        List<Player> players = match.getPlayers();
        players.sort(Comparator.comparingInt(Player::getLevel));

        match.addTeamAPlayer(players.get(0));
        match.addTeamAPlayer(players.get(1));
        match.addTeamAPlayer(players.get(5));

        match.addTeamBPlayer(players.get(2));
        match.addTeamBPlayer(players.get(3));
        match.addTeamBPlayer(players.get(4));
    }
}
package com.ram.Mediator.practice.GameServer.Helpers.Match;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final List<Player> players = new ArrayList<>();
    private final List<Player> TeamA = new ArrayList<>();
    private final List<Player> TeamB = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addTeamAPlayer(Player player){
        player.setTeam(Team.A);
        TeamA.add(player);
    }

    public void addTeamBPlayer(Player player){
        player.setTeam(Team.B);
        TeamB.add(player);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Player> getTeamA() {
        return TeamA;
    }

    public List<Player> getTeamB() {
        return TeamB;
    }
}
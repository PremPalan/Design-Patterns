package com.ram.Mediator.practice.GameServer.Colleague;

import com.ram.Mediator.practice.GameServer.Event.Event;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.Guild;
import com.ram.Mediator.practice.GameServer.Helpers.Match.Team;
import com.ram.Mediator.practice.GameServer.Mediator.GameMediator;

public abstract class Player {
    private final int player_id;
    private final String username;
    private final GameMediator server;

    private int Health = 100;
    private Position position;
    private boolean isDead = false;
    private Guild guild = null;
    private int level = 1;
    private Team team = null;

    protected Player(int playerId, String username, GameMediator server, Position position) {
        player_id = playerId;
        this.username = username;
        this.server = server;
        this.position = position;
    }

    public abstract void sendAttack(Player target);

    public abstract void sendTradeRequest(Player target);

    public abstract int getDamage();

    public abstract int getRange();

    protected GameMediator getServer() {
        return server;
    }

    public void receiveDamage(Player player){
        Health -= player.getDamage();
    }

    public Position getPosition() {
        return position;
    }

    public int getHealth(){
        return Health;
    }

    public boolean isDead(){
        return isDead;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getUsername() {
        return username;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Guild getGuild() {
        return guild;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void receiveEvent(Event event){
        if(event == null){
            return;
        }
        System.out.println(username + " received event: " + event.getType() + " - " + event.getMessage());
    }

    public void receiveMessage(String message){
        System.out.println(username + " received message: " + message);
    }

    public void requestJoinGuild(){
        System.out.println(username + " requested to join a guild.");
    }

    public void leaveGuild(){

        if(guild == null){
            System.out.println("Not in guild...");
            return;
        }

        guild = null;

        System.out.println(username + " left the guild...");
    }

    public void sendGuildMessage(){
        if(guild == null){
            System.out.println("Not in guild...");
            return;
        }
        System.out.println(username + " sent a guild message.");
    }
}
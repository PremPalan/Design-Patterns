package com.ram.Mediator.practice.GameServer;

import com.ram.Mediator.practice.GameServer.Colleague.*;
import com.ram.Mediator.practice.GameServer.Event.Event;
import com.ram.Mediator.practice.GameServer.Helpers.CombatManager;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.Guild;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.GuildManager;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.GuildMember;
import com.ram.Mediator.practice.GameServer.Helpers.MatchMakingService;
import com.ram.Mediator.practice.GameServer.Helpers.RuleEngine;
import com.ram.Mediator.practice.GameServer.Helpers.Chat.ChatRoom;
import com.ram.Mediator.practice.GameServer.Mediator.GameServer;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.Role.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        RuleEngine ruleEngine = new RuleEngine();
        CombatManager combatManager = new CombatManager(ruleEngine);
        GuildManager guildManager = new GuildManager();
        MatchMakingService matchMakingService = new MatchMakingService();

        GameServer server = new GameServer(players, combatManager, guildManager, matchMakingService);

        Position p1 = new Position();
        p1.setX(0);
        p1.setY(0);
        Position p2 = new Position();
        p2.setX(2);
        p2.setY(1);
        Position p3 = new Position();
        p3.setX(5);
        p3.setY(2);
        Position p4 = new Position();
        p4.setX(7);
        p4.setY(3);
        Position p5 = new Position();
        p5.setX(9);
        p5.setY(4);
        Position p6 = new Position();
        p6.setX(11);
        p6.setY(5);

        Player warrior = new Warrior(1, "Ram", server, p1);
        Player mage = new Mage(2, "Aryan", server, p2);
        Player archer = new Archer(3, "Neha", server, p3);
        Player warrior2 = new Warrior(4, "Dev", server, p4);
        Player mage2 = new Mage(5, "Karan", server, p5);
        Player archer2 = new Archer(6, "Isha", server, p6);

        warrior.setLevel(20);
        mage.setLevel(15);
        archer.setLevel(18);
        warrior2.setLevel(12);
        mage2.setLevel(10);
        archer2.setLevel(14);

        players.add(warrior);
        players.add(mage);
        players.add(archer);
        players.add(warrior2);
        players.add(mage2);
        players.add(archer2);

        guildManager.createGuild(warrior, "Shadow Hunters");

        guildManager.invitePlayer(warrior, mage);
        guildManager.acceptInvite(mage, "Shadow Hunters");

        guildManager.invitePlayer(warrior, archer);
        guildManager.acceptInvite(archer, "Shadow Hunters");

        Guild guild = warrior.getGuild();
        GuildMember leader = findMember(guild, warrior.getPlayer_id());
        GuildMember mageMember = findMember(guild, mage.getPlayer_id());
        GuildMember archerMember = findMember(guild, archer.getPlayer_id());

        guildManager.broadcastGuildMessage(leader, "Welcome to the guild!");
        guildManager.promoteMember(leader, mageMember);

        guildManager.removeMember(leader, archerMember);

        ChatRoom room = server.createChatRoom("Lobby");
        room.addPlayer(warrior);
        room.addPlayer(mage);
        room.addPlayer(archer);
        room.addPlayer(warrior2);

        server.sendPrivateMessage(warrior, "Lobby", "Hello everyone!");

        warrior.sendAttack(mage);
        mage.sendTradeRequest(archer);

        Event event = new Event("WORLD_EVENT", "Dragon has spawned!", p1);
        server.broadcastEvent(event);

        for(Player player : players){
            server.startMatchMaking(player);
        }
    }

    private static GuildMember findMember(Guild guild, int playerId) {
        for (GuildMember member : guild.getMembers()) {
            if (member.getPlayer().getPlayer_id() == playerId) {
                return member;
            }
        }
        return null;
    }
}
package com.ram.Mediator.practice.GameServer.Mediator;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Event.Event;
import com.ram.Mediator.practice.GameServer.Helpers.Chat.ChatRoom;
import com.ram.Mediator.practice.GameServer.Helpers.Chat.ChatRoomManager;
import com.ram.Mediator.practice.GameServer.Helpers.CombatManager;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.GuildManager;
import com.ram.Mediator.practice.GameServer.Helpers.MatchMakingService;
import com.ram.Mediator.practice.GameServer.Helpers.ZoneBroadcaster;

import java.util.List;

public class GameServer implements GameMediator{
    private final List<Player> players;
    private final CombatManager combatManager;
    private final GuildManager guildManager;
    private final MatchMakingService matchMakingService;
    private final ChatRoomManager chatRoomManager = new ChatRoomManager();
    private final ZoneBroadcaster zoneBroadcaster = new ZoneBroadcaster();

    public GameServer(List<Player> players, CombatManager combatManager, GuildManager guildManager, MatchMakingService matchMakingService) {
        this.players = players;
        this.combatManager = combatManager;
        this.guildManager = guildManager;
        this.matchMakingService = matchMakingService;
    }

    @Override
    public void attack(Player attacker, Player Target) {
        combatManager.processAttack(attacker, Target);
    }

    @Override
    public void trade(Player sender, Player receiver) {
        System.out.println(sender.getUsername() + " sent a trade request to " + receiver.getUsername());
    }

    @Override
    public void sendTeamRequest(Player sender, Player receiver) {
        System.out.println(sender.getUsername() + " sent a team request to " + receiver.getUsername());
    }

    @Override
    public void broadcastEvent(Event event) {
        if(event != null && event.getPosition() != null){
            zoneBroadcaster.broadcastNearby(event, event.getPosition(), players);
            return;
        }

        for(Player player : players){
            player.receiveEvent(event);
        }
    }

    public ChatRoom createChatRoom(String roomName){
        return chatRoomManager.createRoom(roomName);
    }

    public void sendPrivateMessage(Player sender, String roomId, String message){
        chatRoomManager.sendMessage(roomId, sender, message);
    }

    public void startMatchMaking(Player player){
        matchMakingService.enqueue(player);
        matchMakingService.createMatch();
    }
}
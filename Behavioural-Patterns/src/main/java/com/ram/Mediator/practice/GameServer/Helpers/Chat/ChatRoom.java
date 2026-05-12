package com.ram.Mediator.practice.GameServer.Helpers.Chat;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private final String roomId;
    private final List<Player> players = new ArrayList<>();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if (player != null && !players.contains(player)) {
            players.add(player);
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void sendMessage(Player sender, String message) {
        if (sender == null || message == null) {
            return;
        }

        for (Player player : players) {
            player.receiveMessage("[" + roomId + "] " + sender.getUsername() + ": " + message);
        }
    }
}
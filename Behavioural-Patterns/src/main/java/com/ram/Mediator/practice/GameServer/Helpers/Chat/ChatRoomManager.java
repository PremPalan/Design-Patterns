package com.ram.Mediator.practice.GameServer.Helpers.Chat;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomManager {
    private final Map<String, ChatRoom> rooms = new HashMap<>();

    public ChatRoom createRoom(String roomName) {
        ChatRoom room = rooms.get(roomName);
        if (room == null) {
            room = new ChatRoom(roomName);
            rooms.put(roomName, room);
        }
        return room;
    }

    public ChatRoom getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public void addPlayer(String roomId, Player player) {
        ChatRoom room = rooms.get(roomId);
        if (room != null) {
            room.addPlayer(player);
        }
    }

    public void removePlayer(String roomId, Player player) {
        ChatRoom room = rooms.get(roomId);
        if (room != null) {
            room.removePlayer(player);
        }
    }

    public void sendMessage(String roomId, Player sender, String message) {
        ChatRoom room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Chat room not found...");
            return;
        }
        room.sendMessage(sender, message);
    }
}
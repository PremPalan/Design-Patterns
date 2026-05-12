package com.ram.Mediator.practice.GameServer.Helpers.Guild;

import com.ram.Mediator.practice.GameServer.Colleague.Player;

import java.util.UUID;

enum Status{
    PENDING,
    ACCEPTED
}

public class GuildInvite {

    private UUID inviteId;
    private Player sender;
    private Player receiver;
    private Guild guild;
    private Status status;

    public GuildInvite(UUID inviteId,
                       Player sender,
                       Player receiver,
                       Guild guild,
                       Status status) {

        this.inviteId = inviteId;
        this.sender = sender;
        this.receiver = receiver;
        this.guild = guild;
        this.status = status;
    }

    public UUID getInviteId() {
        return inviteId;
    }

    public Player getSender() {
        return sender;
    }

    public Player getReceiver() {
        return receiver;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
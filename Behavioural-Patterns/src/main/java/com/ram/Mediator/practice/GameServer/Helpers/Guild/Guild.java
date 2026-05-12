package com.ram.Mediator.practice.GameServer.Helpers.Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Guild {

    private final UUID guildId;
    private final String guildName;
    private GuildMember leader;

    private final int maxMembers = 5;

    private final List<GuildMember> members = new ArrayList<>();

    private int guildLevel = 1;
    private int guildTreasury = 5000;

    public Guild(UUID guildId, String guildName, GuildMember leader) {
        this.guildId = guildId;
        this.guildName = guildName;
        this.leader = leader;
    }

    public void addMember(GuildMember member){

        if(members.size() < maxMembers){
            members.add(member);
        }else{
            System.out.println("Guild Size Full.....");
        }
    }

    public void removeMember(GuildMember member){
        members.removeIf(it ->
                it.getPlayer().getPlayer_id()
                        == member.getPlayer().getPlayer_id()
        );
    }

    public GuildMember getLeader(){
        return leader;
    }

    public void setLeader(GuildMember leader) {
        this.leader = leader;
    }

    public String getGuildName() {
        return guildName;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public int getGuildLevel() {
        return guildLevel;
    }

    public int getGuildTreasury() {
        return guildTreasury;
    }

    public void setGuildLevel(int guildLevel) {
        this.guildLevel = guildLevel;
    }

    public void setGuildTreasury(int guildTreasury) {
        this.guildTreasury = guildTreasury;
    }

    public List<GuildMember> getMembers() {
        return members;
    }
}
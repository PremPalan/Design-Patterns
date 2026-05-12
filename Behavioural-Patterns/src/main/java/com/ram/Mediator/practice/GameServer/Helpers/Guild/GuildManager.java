package com.ram.Mediator.practice.GameServer.Helpers.Guild;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.Role.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GuildManager {
    private final Map<String, Guild> guilds = new HashMap<>();
    private final List<GuildInvite> pendingInvites = new ArrayList<>();

    public void createGuild(Player leader, String name){
        GuildMember gm = new GuildMember(leader);
        gm.setRole(Role.LEADER);
        gm.setJoinDate(new Date());

        Guild guild = new Guild(UUID.randomUUID(), name, gm);

        guild.addMember(gm);
        leader.setGuild(guild);

        guilds.put(name, guild);

        System.out.println("Guild Created Successfully...");
    }

    public void disbandGuild(String guildName){
        Guild guild = guilds.get(guildName);

        if(guild == null){
            System.out.println("Guild Not Found...");
            return;
        }

        for(GuildMember member : guild.getMembers()){
            member.getPlayer().setGuild(null);
        }

        guilds.remove(guildName);

        System.out.println("Guild Disbanded...");
    }

    public void invitePlayer(Player sender, Player receiver){
        if(sender.getGuild() == null){
            System.out.println("Sender is not in any guild...");
            return;
        }

        GuildInvite invite = new GuildInvite(
                UUID.randomUUID(),
                sender,
                receiver,
                sender.getGuild(),
                Status.PENDING
        );

        pendingInvites.add(invite);

        System.out.println(receiver.getUsername() + " invited to guild...");
    }

    public void acceptInvite(Player receiver, String guildName){

        for(GuildInvite invite : pendingInvites){

            if(invite.getReceiver().getPlayer_id() == receiver.getPlayer_id()
                    && invite.getGuild().getGuildName().equals(guildName)
                    && invite.getStatus() == Status.PENDING){

                GuildMember member = new GuildMember(receiver);
                member.setRole(Role.MEMBER);
                member.setJoinDate(new Date());

                invite.getGuild().addMember(member);
                receiver.setGuild(invite.getGuild());

                invite.setStatus(Status.ACCEPTED);
                pendingInvites.remove(invite);

                System.out.println(receiver.getUsername() + " joined guild...");
                return;
            }
        }

        System.out.println("No Pending Invite Found...");
    }

    public void removeMember(GuildMember requester, GuildMember target){

        if(!requester.getPlayer().getGuild().getGuildName()
                .equals(target.getPlayer().getGuild().getGuildName())){

            System.out.println("Not in same Guild");

        }else if((requester.getRole() == Role.LEADER)
                || (requester.getRole() == Role.OFFICER
                && target.getRole() == Role.MEMBER)){

            Guild guild = requester.getPlayer().getGuild();

            guild.removeMember(target);

            target.getPlayer().setGuild(null);

            System.out.println("Member Removed...");
        }else{
            System.out.println("Request Denied......");
        }
    }

    public void promoteMember(GuildMember requester, GuildMember target){

        if(!requester.getPlayer().getGuild().getGuildName()
                .equals(target.getPlayer().getGuild().getGuildName())){

            System.out.println("Not in same Guild");

        }else if(requester.getRole() == Role.LEADER){

            if(target.getRole() == Role.MEMBER){

                target.setRole(Role.OFFICER);

            }else if(target.getRole() == Role.OFFICER){
                transferLeadership(requester.getPlayer().getGuild(), requester, target);
                return;

            }else{
                System.out.println("Cannot Promote a leader...");
            }

        }else if(requester.getRole() == Role.OFFICER){

            if(target.getRole() == Role.MEMBER){

                target.setRole(Role.OFFICER);

            }else{
                System.out.println("Cannot promote a officer....");
            }

        }else{
            System.out.println("Request Denied......");
        }
    }

    public void broadcastGuildMessage(GuildMember sender, String message){

        if(sender.getPlayer().getGuild() == null){
            System.out.println("Player not in guild...");
            return;
        }

        Guild guild = sender.getPlayer().getGuild();

        for(GuildMember member : guild.getMembers()){

            if(member.getPlayer().getPlayer_id() != sender.getPlayer().getPlayer_id()){
                member.getPlayer().receiveMessage(
                        "[Guild Chat] " + sender.getPlayer().getUsername() + " : " + message
                );
            }
        }
    }

    public void transferLeadership(Guild guild,
                                   GuildMember currentLeader,
                                   GuildMember newLeader){

        if(guild == null || currentLeader.getRole() != Role.LEADER){
            System.out.println("Only Leader can transfer leadership...");
            return;
        }

        currentLeader.setRole(Role.OFFICER);
        newLeader.setRole(Role.LEADER);
        guild.setLeader(newLeader);

        System.out.println("Leadership transferred...");
    }
}
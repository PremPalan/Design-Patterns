package com.ram.Mediator.practice.GameServer.Helpers.Guild;

import com.ram.Mediator.practice.GameServer.Colleague.Player;
import com.ram.Mediator.practice.GameServer.Helpers.Guild.Role.Role;


import java.util.Date;

public class GuildMember {
    private Player player;
    private Role role;
    private Date joinDate;
    private int contributionPoints;

    public GuildMember(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(int contributionPoints) {
        this.contributionPoints = contributionPoints;
    }
}

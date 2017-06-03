package com.fantazy.league.domain;

/**
 * Created by Praveen on 6/2/2017.
 */
public class Team {
    private String teamName;
    private String[] players;

    public Team(String teamName, String[] players) {
        this.teamName = teamName;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public String[] getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return teamName.equals(team.teamName);
    }

    @Override
    public int hashCode() {
        return teamName.hashCode();
    }
}

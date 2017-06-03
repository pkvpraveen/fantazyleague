package com.fantazy.league.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class TeamTest {


    @Test
    public void shouldHaveNameAndMembers() {
        String[] teamMembers = {"sachin", "ganguly", "dravid"};
        String teamName = "TeamName";

        Team team = new Team(teamName, teamMembers);

        assertEquals(teamName, team.getTeamName());
        assertArrayEquals(teamMembers, team.getPlayers());
    }

    @Test
    public void shouldBeEqualIfNameIsSame() {
        Team team1 = new Team("teamName", null);
        Team team2 = new Team("teamName", null);

        assertEquals(team1, team2);
    }
}
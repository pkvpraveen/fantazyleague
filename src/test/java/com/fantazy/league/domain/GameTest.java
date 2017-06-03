package com.fantazy.league.domain;

import com.fantazy.league.rules.ExtraRunRule;
import com.fantazy.league.service.PointCalculatorService;
import com.fantazy.league.dao.PlayerDao;
import com.fantazy.league.rules.RunRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Praveen on 6/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private Game game;
    @Mock
    private PointCalculatorService pointCalculatorService;

    @Before
    public void setUp() {
        game = new Game(pointCalculatorService);
    }

    @Test
    public void shouldBeAbleToAddATeam() {
        String teamName = "TeamName";
        String[] teamMembers = {"Sachin", "Ganguly", "Prasad", "Yuvraj"};

        game.addTeam(teamName, teamMembers);

        assertEquals(1, game.getTeamCount());
    }

    @Test
    public void shouldBeAbleTwoAddTwoTeams() {

        game.addTeam("TeamName1", "Sachin", "Ganguly", "Prasad", "Yuvraj");
        game.addTeam("TeamName2", "Sachin", "Ganguly", "Prasad", "Yuvraj");

        assertEquals(2, game.getTeamCount());
    }

    @Test
    public void teamNameShouldBeUnique() {
        game.addTeam("TeamName1", "Sachin", "Ganguly", "Prasad", "Yuvraj");
        game.addTeam("TeamName1", "Sachin", "Ganguly", "Prasad", "Yuvraj");

        assertEquals(1, game.getTeamCount());
    }

    @Test
    public void shouldBeAbleToGetWinner() {
        when(pointCalculatorService.calculatePoints(createTeamWithName("TeamName1"))).thenReturn(10);
        when(pointCalculatorService.calculatePoints(createTeamWithName("TeamName2"))).thenReturn(20);
        game.addTeam("TeamName1", "Sachin", "Ganguly", "Prasad", "Yuvraj");
        game.addTeam("TeamName2", "Sachin", "Ganguly", "Prasad", "Yuvraj");

        String winner = game.winner();

        assertEquals("TeamName2", winner);
    }

    @Test
    public void shouldSayNoWinnerIfNoWinner() {

        String winner = game.winner();

        assertEquals("No Winner", winner);
    }

    @Test
    public void shouldSayNoWinnerIfPointsAreEqual() {
        when(pointCalculatorService.calculatePoints(createTeamWithName("TeamName1"))).thenReturn(10);
        when(pointCalculatorService.calculatePoints(createTeamWithName("TeamName2"))).thenReturn(10);
        game.addTeam("TeamName1", "Sachin", "Ganguly", "Prasad", "Yuvraj");
        game.addTeam("TeamName2", "Sachin", "Ganguly", "Prasad", "Yuvraj");

        String winner = game.winner();

        assertEquals("No Winner", winner);
    }

    @Test
    public void PlayGame() {
        Game game = new Game(new PointCalculatorService(asList(
                new RunRule(),
                new ExtraRunRule()
        ), new PlayerDao()));
        game.addTeam("Team1", "Sachin", "Kamly", "Sewag");
        game.addTeam("Team2", "Kumble", "Ganguly", "Dravid");

        System.out.println(game.winner());
    }

    private Team createTeamWithName(String teamName1) {
        return new Team(teamName1, null);
    }
}

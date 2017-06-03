package com.fantazy.league.service;

import com.fantazy.league.dao.PlayerDao;
import com.fantazy.league.domain.Player;
import com.fantazy.league.domain.Team;
import com.fantazy.league.rules.Rule;
import com.fantazy.league.service.PointCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fantazy.league.testutils.RandomUtil.randomIntBetween;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Praveen on 6/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PointCalculatorServiceTest {

    private int POINTS_PER_RULE = 10;
    @Mock
    private PlayerDao playerDao;

    @Before
    public void setUp() {
        POINTS_PER_RULE = randomIntBetween(1, 9);
    }

    @Test
    public void shouldCalculatePointsForTeam() {
        String[] players = {"p", "r"};
        Player player = new Player("");
        when(playerDao.getPlayerByName(anyString())).thenReturn(player);

        int numberOfRules = randomIntBetween(1, 9);
        List<Rule> rules = simulateRules(numberOfRules);
        int expectedPoints = POINTS_PER_RULE * numberOfRules * players.length;
        PointCalculatorService pointCalculatorService = new PointCalculatorService(rules, playerDao);

        int points = pointCalculatorService.calculatePoints(new Team("A", players));

        assertEquals(expectedPoints, points);
        rules.forEach(rule -> verify(rule, times(players.length)).calculatePoints(player));
    }

    public List<Player> players(String[] playerNames) {
        return Arrays.stream(playerNames).map(Player::new).collect(toList());
    }

    public List<Rule> simulateRules(int numberOfRules) {
        List<Rule> rules = new ArrayList<>();
        for (int i = 0; i < numberOfRules; i++) {
            Rule rule = mock(Rule.class);
            when(rule.calculatePoints(any(Player.class))).thenReturn(POINTS_PER_RULE);
            rules.add(rule);
        }
        return rules;
    }
}
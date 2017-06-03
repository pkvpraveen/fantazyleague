package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;
import com.fantazy.league.domain.PlayerType;
import com.fantazy.league.testutils.RandomUtil;
import org.junit.Before;
import org.junit.Test;

import static com.fantazy.league.testutils.RandomUtil.randomIntBetween;
import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class RunRuleTest {

    private final Player player = new Player("player");
    private final RunRule runRule = new RunRule();
    private int runs;

    @Before
    public void setUp() {
        runs = randomIntBetween(1, 9);
        player.setRuns(runs);
    }

    @Test
    public void shouldGetTwoPointForARunForBatsman() {
        player.setType(PlayerType.BATSMAN);

        int points = runRule.calculatePoints(player);

        assertEquals(runs * 2, points);
    }

    @Test
    public void shouldGetOnePointPerRunForAllRounder() {
        player.setType(PlayerType.ALL_ROUNDER);

        int points = runRule.calculatePoints(player);

        assertEquals(runs, points);
    }
}
package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;
import com.fantazy.league.domain.PlayerType;
import org.junit.Before;
import org.junit.Test;

import static com.fantazy.league.testutils.RandomUtil.randomIntBetween;
import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class CatchRuleTest {

    private Player player;
    private int catches;

    @Before
    public void setUp() {
        player = new Player("");
        catches = randomIntBetween(1, 6);
        player.setCatches(catches);
    }

    @Test
    public void shouldGet10PointPerCatchForBatsMan() {
        player.setType(PlayerType.BATSMAN);

        int points = new CatchRule().calculatePoints(player);

        assertEquals(catches * 10, points);
    }

    @Test
    public void shouldGet12PointPerCatchForAllRounder() {
        player.setType(PlayerType.ALL_ROUNDER);

        int points = new CatchRule().calculatePoints(player);

        assertEquals(catches * 12, points);
    }


}
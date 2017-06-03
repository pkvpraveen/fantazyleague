package com.fantazy.league.domain;

import org.junit.Test;

import static com.fantazy.league.testutils.RandomUtil.randomIntBetween;
import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class PlayerTest {

    private final Player player = new Player("name");

    @Test
    public void shouldHaveAName() {
        Player player = new Player("name");
        assertEquals("name", player.getName());
    }

    @Test
    public void shouldHaveRuns() {
        int runs = randomIntBetween(1, 9);
        player.setRuns(runs);
        assertEquals(runs, player.getRuns());
    }

    @Test
    public void shouldHaveCatches() {
        int catches = randomIntBetween(1, 9);
        player.setCatches(catches);
        assertEquals(catches, player.getCatches());
    }

    @Test
    public void shouldHavePlayerType() {
        player.setType(PlayerType.ALL_ROUNDER);
        assertEquals(PlayerType.ALL_ROUNDER, player.getType());
    }
}
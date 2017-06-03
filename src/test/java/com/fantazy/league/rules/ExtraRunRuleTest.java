package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;
import org.junit.Test;

import static com.fantazy.league.testutils.RandomUtil.randomIntBetween;
import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class ExtraRunRuleTest {

    private Player player = new Player("");
    private Rule runRule = new ExtraRunRule();

    @Test
    public void shouldGet5RunsExtraFor30() {
        player.setRuns(randomIntBetween(30, 45));
        assertEquals(5, runRule.calculatePoints(player));
    }

    @Test
    public void shouldGet10RunsFor45() {
        player.setRuns(randomIntBetween(45, 60));
        assertEquals(10, runRule.calculatePoints(player));
    }

    @Test
    public void shouldGet15RunsFor60() {
        player.setRuns(randomIntBetween(60, 75));
        assertEquals(15, runRule.calculatePoints(player));
    }

    @Test
    public void shouldGet20RunsFor75() {
        player.setRuns(randomIntBetween(75, 90));
        assertEquals(20, runRule.calculatePoints(player));
    }

}
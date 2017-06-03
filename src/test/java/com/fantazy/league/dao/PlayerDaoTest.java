package com.fantazy.league.dao;

import com.fantazy.league.dao.PlayerDao;
import com.fantazy.league.domain.PlayerType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 6/2/2017.
 */
public class PlayerDaoTest {

    @Test
    public void shouldHavePlayersWithRuns() {
        PlayerDao playerDao = new PlayerDao();

        assertEquals("Sachin", playerDao.getPlayerByName("Sachin").getName());
        assertEquals("Ganguly", playerDao.getPlayerByName("Ganguly").getName());
        assertEquals("Sewag", playerDao.getPlayerByName("Sewag").getName());
        assertEquals("Kumble", playerDao.getPlayerByName("Kumble").getName());
        assertEquals("Kamly", playerDao.getPlayerByName("Kamly").getName());
        assertEquals("Dravid", playerDao.getPlayerByName("Dravid").getName());
        assertEquals(100, playerDao.getPlayerByName("Sachin").getRuns());
        assertEquals(67, playerDao.getPlayerByName("Ganguly").getRuns());
        assertEquals(47, playerDao.getPlayerByName("Sewag").getRuns());
        assertEquals(5, playerDao.getPlayerByName("Kumble").getRuns());
        assertEquals(35, playerDao.getPlayerByName("Kamly").getRuns());
        assertEquals(122, playerDao.getPlayerByName("Dravid").getRuns());

        assertEquals(3, playerDao.getPlayerByName("Sachin").getCatches());
        assertEquals(0, playerDao.getPlayerByName("Ganguly").getCatches());
        assertEquals(2, playerDao.getPlayerByName("Sewag").getCatches());
        assertEquals(1, playerDao.getPlayerByName("Kumble").getCatches());
        assertEquals(4, playerDao.getPlayerByName("Kamly").getCatches());
        assertEquals(5, playerDao.getPlayerByName("Dravid").getCatches());

        assertEquals(PlayerType.ALL_ROUNDER, playerDao.getPlayerByName("Sachin").getType());
        assertEquals(PlayerType.ALL_ROUNDER, playerDao.getPlayerByName("Ganguly").getType());
        assertEquals(PlayerType.BATSMAN, playerDao.getPlayerByName("Sewag").getType());
        assertEquals(PlayerType.ALL_ROUNDER, playerDao.getPlayerByName("Kumble").getType());
        assertEquals(PlayerType.BATSMAN, playerDao.getPlayerByName("Kamly").getType());
        assertEquals(PlayerType.BATSMAN, playerDao.getPlayerByName("Dravid").getType());
    }
}
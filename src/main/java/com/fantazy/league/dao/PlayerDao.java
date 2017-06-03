package com.fantazy.league.dao;

import com.fantazy.league.domain.Player;
import com.fantazy.league.domain.PlayerType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Praveen on 6/2/2017.
 */
public class PlayerDao {

    Map<String, Player> players = new HashMap<>();

    public PlayerDao() {
        newPlayer("Sachin", 100, 3, PlayerType.ALL_ROUNDER);
        newPlayer("Ganguly", 67, 0, PlayerType.ALL_ROUNDER);
        newPlayer("Sewag", 47, 2, PlayerType.BATSMAN);
        newPlayer("Kumble", 5, 1, PlayerType.ALL_ROUNDER);
        newPlayer("Kamly", 35, 4, PlayerType.BATSMAN);
        newPlayer("Dravid", 122, 5, PlayerType.BATSMAN);
    }

    private void newPlayer(String name, int runs, int catches, PlayerType type) {
        Player player = new Player(name);
        player.setRuns(runs);
        player.setCatches(catches);
        player.setType(type);
        players.put(name, player);
    }

    public Player getPlayerByName(String name) {
        return players.get(name);
    }
}

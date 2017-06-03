package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;

/**
 * Created by Praveen on 6/2/2017.
 */
public class CatchRule implements Rule {
    public int calculatePoints(Player player) {
        return player.getCatches() * player.getType().getPointsPerCatch();
    }
}

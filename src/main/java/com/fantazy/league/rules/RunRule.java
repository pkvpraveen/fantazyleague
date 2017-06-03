package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;

/**
 * Created by Praveen on 6/2/2017.
 */
public class RunRule implements Rule {
    @Override
    public int calculatePoints(Player player) {
        return player.getRuns() * player.getType().getPointsPerRun();
    }
}

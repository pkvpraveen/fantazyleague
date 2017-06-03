package com.fantazy.league.rules;

import com.fantazy.league.domain.Player;

/**
 * Created by Praveen on 6/2/2017.
 */
public class ExtraRunRule implements Rule {
    @Override
    public int calculatePoints(Player player) {
        return (player.getRuns() / 15 - 1) * 5;
    }
}

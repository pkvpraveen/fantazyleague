package com.fantazy.league.service;

import com.fantazy.league.dao.PlayerDao;
import com.fantazy.league.domain.Team;
import com.fantazy.league.rules.Rule;

import java.util.List;

import static java.util.Arrays.stream;

/**
 * Created by Praveen on 6/2/2017.
 */
public class PointCalculatorService {
    private final List<Rule> rules;
    private PlayerDao playerDao;


    public PointCalculatorService(List<Rule> rules, PlayerDao playerDao) {
        this.rules = rules;
        this.playerDao = playerDao;
    }

    public int calculatePoints(Team team) {
        return stream(team.getPlayers())
                .map(this::getPlayerTotalScore)
                .reduce(Integer::sum).orElse(0);
    }

    private int getPlayerTotalScore(String name) {
        return rules.stream()
                .map(rule -> rule.calculatePoints(playerDao.getPlayerByName(name)))
                .reduce(Integer::sum).orElse(0);
    }

}

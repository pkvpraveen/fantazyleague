package com.fantazy.league.domain;

import com.fantazy.league.service.PointCalculatorService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Praveen on 6/2/2017.
 */
public class Game {
    private PointCalculatorService pointCalculatorService;
    private Set<Team> teams = new HashSet<>();
    private String NO_WINNER = "No Winner";
    ;

    public Game(PointCalculatorService pointCalculatorService) {
        this.pointCalculatorService = pointCalculatorService;
    }

    public void addTeam(String teamName, String... teamMembers) {
        teams.add(new Team(teamName, teamMembers));
    }

    public int getTeamCount() {
        return teams.size();
    }

    public String winner() {
        return getSingleWinner(new Helper().findTeamsWithTopScore());
    }

    private String getSingleWinner(List<String> winners) {
        return winners.size() == 1 ? winners.stream().findFirst().orElse(NO_WINNER) : NO_WINNER;
    }

    private class Helper {
        private Map<String,Integer> teamToPointsMap;
        private int topScore;

        public Helper() {
            this.teamToPointsMap = teams.stream().collect(Collectors.toMap(Team::getTeamName, t -> pointCalculatorService.calculatePoints(t)));
            this.topScore = teamToPointsMap.values().stream().max(Integer::compareTo).orElse(0);
        }

        private List<String> findTeamsWithTopScore() {
            return teamToPointsMap.entrySet()
                    .stream()
                    .filter(e -> e.getValue().equals(topScore))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
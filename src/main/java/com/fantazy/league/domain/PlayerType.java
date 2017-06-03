package com.fantazy.league.domain;

/**
 * Created by Praveen on 6/2/2017.
 */
public enum PlayerType {
    BATSMAN(2, 10), ALL_ROUNDER(1, 12);

    int pointsPerRun;
    int pointsPerCatch;

    PlayerType(int pointsPerRun, int pointsPerCatch) {
        this.pointsPerRun = pointsPerRun;
        this.pointsPerCatch = pointsPerCatch;
    }

    public int getPointsPerRun() {
        return pointsPerRun;
    }

    public int getPointsPerCatch() {
        return pointsPerCatch;
    }
}

package com.fantazy.league.domain;

/**
 * Created by Praveen on 6/2/2017.
 */
public class Player {

    private String name;
    private int runs;
    private int catches;
    private PlayerType type;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getRuns() {
        return runs;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public int getCatches() {
        return catches;
    }

    public void setType(PlayerType playerType) {
        this.type = playerType;
    }

    public PlayerType getType() {
        return type;
    }
}

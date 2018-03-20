package com.example.gemstudios.myufc_app.local_realm.model;

import io.realm.RealmObject;

public class TitleHoldersRealm extends RealmObject {
    private String name;
    private int wins;
    private int draws;
    private int losses;


    public TitleHoldersRealm() {
    }

    public TitleHoldersRealm(String name, int wins, int draws, int losses) {
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
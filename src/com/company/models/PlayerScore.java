package com.company.models;

public class PlayerScore {
    private String username;
    public int score = 0;

    public PlayerScore(String username){
        this.username = username;
    }

    public PlayerScore(String username, int score){
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }
}

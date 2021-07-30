package com.company.models.results;

public class BasketballPlayerStats  extends SportStats{
    private final int scoredPoints;
    private final int rebounds;
    private final int assists;

    public BasketballPlayerStats(String nickname, String teamName, int scoredPoints, int rebounds, int assists) {
        this.nickname = nickname;
        this.teamName = teamName;
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public int getScoredPoints() {
        return scoredPoints;
    }

    public int getRebounds() {
        return rebounds;
    }

    public int getAssists() {
        return assists;
    }
}

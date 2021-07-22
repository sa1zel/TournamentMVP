package com.company.models.results;

public class BasketballPlayerStats {
    String nickname;
    String teamName;
    int scoredPoints;
    int rebounds;
    int assists;

    public BasketballPlayerStats(String nickname, String teamName, int scoredPoints, int rebounds, int assists) {
        this.nickname = nickname;
        this.teamName = teamName;
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }
}

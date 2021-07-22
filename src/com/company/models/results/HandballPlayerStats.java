package com.company.models.results;

public class HandballPlayerStats {
    String teamName;
    String nickname;
    int goalsMade;
    int goalsReceived;

    public HandballPlayerStats(String nickname, String teamName, int goalsMade, int goalsReceived) {
        this.nickname = nickname;
        this.teamName = teamName;
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }
}

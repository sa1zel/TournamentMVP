package com.company.models.results;

public class HandballPlayerStats extends SportStats {
    private final int goalsMade;
    private final int goalsReceived;


    public HandballPlayerStats(String nickname, String teamName, int goalsMade, int goalsReceived) {
        this.nickname = nickname;
        this.teamName = teamName;
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsMade() {
        return goalsMade;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }
}

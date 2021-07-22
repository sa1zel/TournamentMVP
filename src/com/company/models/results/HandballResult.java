package com.company.models.results;

import com.company.models.PlayerScore;

import java.util.ArrayList;
import java.util.List;

public class HandballResult implements SportResult {
    private List<HandballPlayerStats> handballPlayersStatistics;

    public HandballResult(List<HandballPlayerStats> handballUserStatistics) {
        this.handballPlayersStatistics = handballUserStatistics;
    }

    @Override
    public List<PlayerScore> getPlayersResults() {
        String firstTeamName = "";
        String secondTeamName = "";
        int firstTeamScore = 0;
        int secondTeamScore = 0;
        List<PlayerScore> firstTeamCountedResult = new ArrayList<>();
        List<PlayerScore> secondTeamCountedResult = new ArrayList<>();

        for (HandballPlayerStats playerStats : handballPlayersStatistics) {
            int userRatingPoints = playerStats.goalsMade * 2 - playerStats.goalsReceived;
            PlayerScore currentUserResult = new PlayerScore(playerStats.nickname, userRatingPoints);
            if (firstTeamName.isBlank()) {
                firstTeamName = playerStats.teamName;
            } else if (!firstTeamName.equals(playerStats.teamName)
                    && secondTeamName.isBlank()) {
                secondTeamName = playerStats.teamName;
            }
            if (firstTeamName.equals(playerStats.teamName)) {
                firstTeamScore += playerStats.goalsMade;
                firstTeamCountedResult.add(currentUserResult);
            } else if (secondTeamName.equals(playerStats.teamName)) {
                secondTeamScore += playerStats.goalsMade;
                secondTeamCountedResult.add(currentUserResult);
            } else throw new IllegalArgumentException("More than 2 teams");
        }

        if (firstTeamScore > secondTeamScore) {
            firstTeamCountedResult.forEach(result -> result.score += 10);
        } else if (firstTeamScore < secondTeamScore) {
            secondTeamCountedResult.forEach(result -> result.score += 10);
        } else throw new IllegalArgumentException("No winner team");

        firstTeamCountedResult.addAll(secondTeamCountedResult);
        return firstTeamCountedResult;
    }
}

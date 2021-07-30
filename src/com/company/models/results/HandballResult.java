package com.company.models.results;

import com.company.models.PlayerScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandballResult extends SportResult {
    private List<HandballPlayerStats> handballPlayersStatistics;

    public HandballResult(List<HandballPlayerStats> handballUserStatistics) {
        this.handballPlayersStatistics = handballUserStatistics;
    }

    @Override
    public List<PlayerScore> getPlayersResults() {
        Map<String, Integer> countedResult = new HashMap<>();

        for (HandballPlayerStats playerStats : handballPlayersStatistics) {
            int playerRatingPoints = playerStats.getGoalsMade() * 2 - playerStats.getGoalsReceived();
            countedResult.put(playerStats.nickname, playerRatingPoints);
        }

        String winnerTeam = countWinnerTeam(handballPlayersStatistics);

        handballPlayersStatistics.stream()
                .filter(playerStat -> playerStat.teamName.equals(winnerTeam))
                .forEach(playerStats -> countedResult.put(playerStats.nickname, countedResult.get(playerStats.nickname) + winnerTeamPayment));

        return countedResult.entrySet().stream()
                .map(entry -> new PlayerScore(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public int getTeamScore(String teamName) {
        return handballPlayersStatistics.stream()
                .filter(playerStats -> playerStats.teamName.equals(teamName))
                .mapToInt(HandballPlayerStats::getGoalsMade).sum();
    }


}

package com.company.models.results;

import com.company.models.PlayerScore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasketballResult extends SportResult {
    private List<BasketballPlayerStats> basketballPlayersStatistics;

    public BasketballResult(List<BasketballPlayerStats> basketballUserStatistics) {
        this.basketballPlayersStatistics = basketballUserStatistics;
    }

    @Override
    public List<PlayerScore> getPlayersResults() {
        Map<String, Integer> countedResult = new HashMap<>();

        for (BasketballPlayerStats playerStats : basketballPlayersStatistics) {
            int playerRatingPoints = playerStats.getScoredPoints() * 2
                    + playerStats.getRebounds()
                    + playerStats.getAssists();
            countedResult.put(playerStats.nickname, playerRatingPoints);
        }

        String winnerTeam = countWinnerTeam(basketballPlayersStatistics);

        basketballPlayersStatistics.stream()
                .filter(playerStat -> playerStat.teamName.equals(winnerTeam))
                .forEach(playerStats -> countedResult.put(playerStats.nickname ,countedResult.get(playerStats.nickname) + winnerTeamPayment));

        return countedResult.entrySet().stream()
                .map( entry-> new PlayerScore(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public int getTeamScore(String teamName) {
        return basketballPlayersStatistics.stream()
                .filter(playerStats -> playerStats.teamName.equals(teamName))
                .mapToInt(BasketballPlayerStats::getScoredPoints).sum();
    }
}

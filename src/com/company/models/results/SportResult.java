package com.company.models.results;

import com.company.models.PlayerScore;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SportResult {
    protected final int winnerTeamPayment = 10;

    public abstract List<PlayerScore> getPlayersResults();

    public abstract int getTeamScore(String teamName);

    protected String countWinnerTeam(List<? extends SportStats> playerStatistics){
        String winner;
        Set<String> teams = playerStatistics.stream()
                .map(SportStats::getTeamName)
                .collect(Collectors.toSet());

        if(teams.size() != 2){
            throw new IllegalArgumentException("Bad data: teams counter" + teams.size());
        }

        Map<String, Integer> teamScores = new TreeMap<>();

        for(String team : teams){
            teamScores.put(team, getTeamScore(team));
        }

        if(new HashSet<>(teamScores.values()).size() == 1){
            throw new IllegalArgumentException("Must be winner team");
        }

        winner = Collections.max(teamScores.entrySet(), Map.Entry.comparingByValue()).getKey();

        return winner;
    }
}

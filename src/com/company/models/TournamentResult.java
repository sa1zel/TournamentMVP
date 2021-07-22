package com.company.models;

import com.company.models.results.SportResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentResult {
    private List<SportResult> sportResults;

    public TournamentResult(List<SportResult> results) {
        this.sportResults = results;
    }

    public PlayerScore getMVP() {
        Map<String, Integer> allUserResults = new HashMap<>();
        for (SportResult result : sportResults) {
            List<PlayerScore> userResults = result.getPlayersResults();
            for (PlayerScore userResult : userResults) {
                if (!allUserResults.containsKey(userResult.getUsername())) {
                    allUserResults.put(userResult.getUsername(), 0);
                }
                int newScore = allUserResults.get(userResult.getUsername()) + userResult.getScore();
                allUserResults.put(userResult.getUsername(), newScore);
            }
        }
        //MVP: If scores equal, MVP will be the first in the list
        String mvpUsername = Collections.max(allUserResults.entrySet(), Map.Entry.comparingByValue()).getKey();

        return new PlayerScore(mvpUsername, allUserResults.get(mvpUsername));
    }
}

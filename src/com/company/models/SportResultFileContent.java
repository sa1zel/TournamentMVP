package com.company.models;

import java.util.List;

public class SportResultFileContent {
    private String sportName;
    private List<String> playersStats;

    public SportResultFileContent(String sportName, List<String> playersStats) {
        this.sportName = sportName;
        this.playersStats = playersStats;
    }

    public String getSportName() {
        return sportName;
    }

    public List<String> getPlayersStats() {
        return playersStats;
    }
}

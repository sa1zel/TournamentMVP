package com.company;

import com.company.models.results.SportResult;
import com.company.models.TournamentResult;
import com.company.models.PlayerScore;
import com.company.repositories.TournamentResultsFromDirectoryRepository;
import com.company.repositories.TournamentResultsRepository;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String pathDir = "tournamentScoresFiles";
        TournamentResultsRepository resultsRepository = new TournamentResultsFromDirectoryRepository(pathDir);
        List<SportResult> sportResults = resultsRepository.getResults();
        TournamentResult tournamentResult = new TournamentResult(sportResults);
        PlayerScore mvp = tournamentResult.getMVP();
        System.out.println(mvp.getUsername() + "  " + mvp.getScore());
    }
}

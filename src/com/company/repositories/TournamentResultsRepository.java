package com.company.repositories;

import com.company.models.results.SportResult;

import java.io.IOException;
import java.util.List;

public interface TournamentResultsRepository {
    List<SportResult> getResults() throws IOException;
}

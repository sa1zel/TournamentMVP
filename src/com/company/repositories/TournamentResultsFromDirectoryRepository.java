package com.company.repositories;

import com.company.models.results.SportResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TournamentResultsFromDirectoryRepository implements TournamentResultsRepository {
    private String pathDir;
    private SportResultFromFileFactory sportResultFactory = new SportResultFromFileFactory();

    public TournamentResultsFromDirectoryRepository(String pathDir){
        this.pathDir = pathDir;
    }

    @Override
    public List<SportResult> getResults() throws IOException {
        List<Path> paths = Files.walk(Paths.get(pathDir))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
        return paths.stream().map(path -> {
            try {
                return sportResultFactory.create(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }
}

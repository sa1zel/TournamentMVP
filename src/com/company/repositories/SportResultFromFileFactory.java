package com.company.repositories;

import com.company.models.*;
import com.company.models.results.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SportResultFromFileFactory {

    private SportResultFileContent readFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String sportName = lines.get(0);
        lines.remove(0);
        return new SportResultFileContent(sportName, lines);
    }

    public SportResult create(Path filePath) throws IOException {
        SportResultFileContent fileContent = readFile(filePath);
        String sportName = fileContent.getSportName();
        if (sportName.equals("BASKETBALL")) {
            return new BasketballResult(parseBasketballPlayerStats(fileContent.getPlayersStats()));
        }
        if (sportName.equals("HANDBALL"))
            return new HandballResult(parseHandballPlayerStats(fileContent.getPlayersStats()));
        throw new IllegalArgumentException("Wrong sport name " + sportName);
    }

    private List<BasketballPlayerStats> parseBasketballPlayerStats(List<String> playersStats) {
        List<BasketballPlayerStats> result = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (String stat : playersStats) {
            String[] statValues = stat.split(";");
            nicknames.add(statValues[1]);
            result.add(new BasketballPlayerStats(statValues[1],
                    statValues[3],
                    Integer.parseInt(statValues[4]),
                    Integer.parseInt(statValues[5]),
                    Integer.parseInt(statValues[6])));
        }

        if (!usersNicknamesIsUnique(nicknames)) {
            throw new IllegalArgumentException("not unique usernames");
        }

        return result;
    }

    private List<HandballPlayerStats> parseHandballPlayerStats(List<String> playersStats) {
        List<HandballPlayerStats> result = new ArrayList<>();

        for (String stat : playersStats) {
            String[] statValues = stat.split(";");
            result.add(new HandballPlayerStats(statValues[1],
                    statValues[3],
                    Integer.parseInt(statValues[4]),
                    Integer.parseInt(statValues[5])));
        }

        return result;
    }

    private boolean usersNicknamesIsUnique(List<String> nicknames) {
        return nicknames.size() == new HashSet<>(nicknames).size();
    }
}

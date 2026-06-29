package org.footgoat.importer;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.footgoat.model.TeamCompetitionSeason;
import org.footgoat.repositories.TeamCompetitionSeasonRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCompetitionSeasonImporter {

    private final TeamCompetitionSeasonRepository repository;

    public void importCsv(String path) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            reader.readNext();

            String[] row;

            List<TeamCompetitionSeason> batch = new ArrayList<>();

            while ((row = reader.readNext()) != null) {

                TeamCompetitionSeason team = new TeamCompetitionSeason();

                team.setClubId(parseLong(row[0]));
                team.setCompetitionName(row[3]);
                team.setCompetitionId(parseLong(row[4]));
                team.setSeasonId(parseInt(row[2]));
                team.setClubDivision(row[5]);

                batch.add(team);

                if (batch.size() == 5000) {
                    repository.saveAll(batch);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                repository.saveAll(batch);
            }
        }
    }

    private Long parseLong(String value) {
        return value == null || value.isBlank() ? null : Long.parseLong(value);
    }

    private Integer parseInt(String value) {
        return value == null || value.isBlank() ? null : Integer.parseInt(value);
    }
}
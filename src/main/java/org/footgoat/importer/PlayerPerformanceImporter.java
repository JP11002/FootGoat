package org.footgoat.importer;


import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.footgoat.model.PlayerPerformance;
import org.footgoat.repositories.PlayerPerformanceRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerPerformanceImporter {
    private final PlayerPerformanceRepository repository;

    public void importCsv(String path) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            reader.readNext(); // Header

            String[] row;

            List<PlayerPerformance> batch = new ArrayList<>();

            while ((row = reader.readNext()) != null) {

                PlayerPerformance performance = new PlayerPerformance();

                performance.setPlayerId(parseLong(row[0]));
                performance.setSeasonName(row[1]);
                performance.setCompetitionId(row[2]);
                performance.setCompetitionName(row[3]);
                performance.setTeamId(parseLong(row[4]));
                performance.setTeamName(row[5]);
                performance.setNbInGroup(parseInt(row[6]));
                performance.setNbOnPitch(parseInt(row[7]));
                performance.setGoals(parseInt(row[8]));
                performance.setAssists(parseInt(row[9]));

                batch.add(performance);

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
        if (value == null || value.isBlank()) {
            return null;
        }
        return (int) Double.parseDouble(value);
    }

}

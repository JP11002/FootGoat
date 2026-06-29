package org.footgoat.importer;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.footgoat.model.PlayerInternationalPerformance;
import org.footgoat.repositories.PlayerInternationalPerformanceRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerInternationalPerformanceImporter {

    private final PlayerInternationalPerformanceRepository repository;

    public void importCsv(String path) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            reader.readNext();

            String[] row;

            List<PlayerInternationalPerformance> batch = new ArrayList<>();

            while ((row = reader.readNext()) != null) {

                PlayerInternationalPerformance performance = new PlayerInternationalPerformance();

                performance.setPlayerId(parseLong(row[0]));
                performance.setTeamId(parseLong(row[1]));
                performance.setMatches(parseInt(row[2]));
                performance.setGoals(parseInt(row[3]));
                performance.setShirtNumber(parseInt(row[4]));
                performance.setCoachId(parseLong(row[5]));
                performance.setDebutGameId(parseLong(row[6]));
                performance.setCareerState(row[7]);

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
        if (value == null || value.isBlank()) {
            return null;
        }

        return (long) Double.parseDouble(value);
    }

    private Integer parseInt(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return (int) Double.parseDouble(value);
    }

    private LocalDate parseDate(String value) {
        return value == null || value.isBlank()
                ? null
                : LocalDate.parse(value);
    }
}
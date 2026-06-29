package org.footgoat.importer;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.footgoat.model.Club;
import org.footgoat.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClubImporter {

    private final ClubRepository repository;

    public void importCsv(String path) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            reader.readNext();

            String[] row;

            List<Club> batch = new ArrayList<>();
            Set<Long> imported = new HashSet<>();

            while ((row = reader.readNext()) != null) {

                Long clubId = parseLong(row[0]);

                if (clubId == null || imported.contains(clubId)) {
                    continue;
                }

                imported.add(clubId);

                Club club = new Club();

                club.setClubId(clubId);
                club.setClubSlug(get(row, 1));
                club.setClubName(get(row, 2));
                club.setLogoUrl(get(row, 3));
                club.setCountryName(get(row, 4));
                club.setCompetitionId(get(row, 6));
                club.setCompetitionSlug(get(row, 7));
                club.setCompetitionName(get(row, 8));
                club.setClubDivision(get(row, 9));

                batch.add(club);

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

    private String get(String[] row, int index) {
        return index < row.length ? row[index] : null;
    }
}

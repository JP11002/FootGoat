package org.footgoat.importer;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.footgoat.model.Player;
import org.footgoat.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerImporter {

    private final PlayerRepository repository;

    public void importCsv(String path) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader(path))) {

            reader.readNext();

            String[] row;

            List<Player> batch = new ArrayList<>();

            while ((row = reader.readNext()) != null) {

                Player player = new Player();

                player.setPlayerId(parseLong(row[0]));
                player.setPlayerSlug(row[1]);
                player.setPlayerName(row[2]);
                player.setPlayerImageUrl(row[3]);
                player.setNameInHomeCountry(row[4]);
                player.setDateOfBirth(parseDate(row[5]));
                player.setPlaceOfBirth(row[6]);
                player.setCountryOfBirth(row[7]);
                player.setHeight(parseInt(row[8]));
                player.setCitizenship(row[9]);
                player.setPosition(row[10]);
                player.setMainPosition(row[11]);

                batch.add(player);

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

    private LocalDate parseDate(String value) {
        return value == null || value.isBlank() ? null : LocalDate.parse(value);
    }
}

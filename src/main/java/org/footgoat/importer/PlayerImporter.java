package org.footgoat.importer;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.footgoat.importer.dto.PlayerDto;
import org.footgoat.importer.mapper.PlayerCsvMapper;
import org.footgoat.player.Player;
import org.footgoat.player.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerImporter implements CommandLineRunner {

    private final PlayerRepository playerRepository;
    private final PlayerCsvMapper playerCsvMapper;

    @Override
    public void run(String... args) throws Exception {

        if (playerRepository.count() > 0) {
            return;
        }

        Reader reader = new InputStreamReader(
                new ClassPathResource("data/players.csv").getInputStream()
        );

        List<PlayerDto> dtos = new CsvToBeanBuilder<PlayerDto>(reader)
                .withType(PlayerDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();

        List<Player> players = dtos.stream()
                .map(playerCsvMapper::toEntity)
                .toList();

        playerRepository.saveAll(players);

        System.out.println("Imported " + players.size() + " players successfully.");
    }
}

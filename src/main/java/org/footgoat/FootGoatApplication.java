package org.footgoat;

import lombok.RequiredArgsConstructor;
import org.footgoat.importer.ClubImporter;
import org.footgoat.importer.PlayerImporter;
import org.footgoat.importer.PlayerInternationalPerformanceImporter;
import org.footgoat.importer.PlayerPerformanceImporter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class FootGoatApplication {

    private final PlayerImporter playerImporter;
    private final ClubImporter clubImporter;
    private final PlayerPerformanceImporter playerPerformanceImporter;
    private final PlayerInternationalPerformanceImporter playerInternationalPerformanceImporter;

    public static void main(String[] args) {
        SpringApplication.run(FootGoatApplication.class, args);
    }


    @Bean
    CommandLineRunner loadData() {
        return args -> {


            //playerImporter.importCsv("src/main/resources/data/player_profiles.csv");
            //System.out.println("Players importados");

             //clubImporter.importCsv("src/main/resources/data/team_details.csv");
            //System.out.println("Clubs importados");

            //playerPerformanceImporter.importCsv("src/main/resources/data/player_performances.csv");
            //System.out.println("Player performances importadas");

            //playerInternationalPerformanceImporter.importCsv("src/main/resources/data/player_national_performances.csv");
            //System.out.println("International performances importadas");
        };
    }

}

package org.footgoat.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    private Long playerId;

    private String firstName;

    private String lastName;

    private String name;

    private Integer lastSeason;

    private Long currentClubId;

    private String playerCode;

    private String countryOfBirth;

    private String cityOfBirth;

    private String countryOfCitizenship;

    private LocalDate dateOfBirth;

    private String subPosition;

    private String position;

    private String foot;

    private Integer heightInCm;

    private LocalDate contractExpirationDate;

    private String agentName;

    private String imageUrl;

    private Integer internationalCaps;

    private Integer internationalGoals;

    private Long currentNationalTeamId;

    private String url;

    private String currentClubDomesticCompetitionId;

    private String currentClubName;

    private Long marketValueInEur;

    private Long highestMarketValueInEur;
}
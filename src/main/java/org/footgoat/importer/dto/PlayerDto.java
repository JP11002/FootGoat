package org.footgoat.importer.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {

    @CsvBindByName(column = "player_id")
    private Long playerId;

    @CsvBindByName(column = "first_name")
    private String firstName;

    @CsvBindByName(column = "last_name")
    private String lastName;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "last_season")
    private Integer lastSeason;

    @CsvBindByName(column = "current_club_id")
    private Long currentClubId;

    @CsvBindByName(column = "player_code")
    private String playerCode;

    @CsvBindByName(column = "country_of_birth")
    private String countryOfBirth;

    @CsvBindByName(column = "city_of_birth")
    private String cityOfBirth;

    @CsvBindByName(column = "country_of_citizenship")
    private String countryOfCitizenship;

    @CsvBindByName(column = "date_of_birth")
    private String dateOfBirth;

    @CsvBindByName(column = "sub_position")
    private String subPosition;

    @CsvBindByName(column = "position")
    private String position;

    @CsvBindByName(column = "foot")
    private String foot;

    @CsvBindByName(column = "height_in_cm")
    private Integer heightInCm;

    @CsvBindByName(column = "contract_expiration_date")
    private String contractExpirationDate;

    @CsvBindByName(column = "agent_name")
    private String agentName;

    @CsvBindByName(column = "image_url")
    private String imageUrl;

    @CsvBindByName(column = "international_caps")
    private Integer internationalCaps;

    @CsvBindByName(column = "international_goals")
    private Integer internationalGoals;

    @CsvBindByName(column = "current_national_team_id")
    private Long currentNationalTeamId;

    @CsvBindByName(column = "url")
    private String url;

    @CsvBindByName(column = "current_club_domestic_competition_id")
    private String currentClubDomesticCompetitionId;

    @CsvBindByName(column = "current_club_name")
    private String currentClubName;

    @CsvBindByName(column = "market_value_in_eur")
    private Long marketValueInEur;

    @CsvBindByName(column = "highest_market_value_in_eur")
    private Long highestMarketValueInEur;
}

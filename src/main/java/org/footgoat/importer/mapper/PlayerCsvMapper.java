package org.footgoat.importer.mapper;

import org.footgoat.importer.dto.PlayerDto;
import org.footgoat.player.Player;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlayerCsvMapper {

    public Player toEntity(PlayerDto dto){
        Player player = new Player();

        player.setPlayerId(dto.getPlayerId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setName(dto.getName());
        player.setLastSeason(dto.getLastSeason());
        player.setCurrentClubId(dto.getCurrentClubId());
        player.setPlayerCode(dto.getPlayerCode());
        player.setCountryOfBirth(dto.getCountryOfBirth());
        player.setCityOfBirth(dto.getCityOfBirth());
        player.setCountryOfCitizenship(dto.getCountryOfCitizenship());

        if (dto.getDateOfBirth() != null && !dto.getDateOfBirth().isBlank()) {
            player.setDateOfBirth(
                    LocalDate.parse(dto.getDateOfBirth().substring(0, 10)));
        }

        player.setSubPosition(dto.getSubPosition());
        player.setPosition(dto.getPosition());
        player.setFoot(dto.getFoot());
        player.setHeightInCm(dto.getHeightInCm());

        if (dto.getContractExpirationDate() != null &&
                !dto.getContractExpirationDate().isBlank()) {

            player.setContractExpirationDate(
                    LocalDate.parse(dto.getContractExpirationDate().substring(0, 10)));
        }

        player.setAgentName(dto.getAgentName());
        player.setImageUrl(dto.getImageUrl());
        player.setInternationalCaps(dto.getInternationalCaps());
        player.setInternationalGoals(dto.getInternationalGoals());
        player.setCurrentNationalTeamId(dto.getCurrentNationalTeamId());
        player.setUrl(dto.getUrl());
        player.setCurrentClubDomesticCompetitionId(
                dto.getCurrentClubDomesticCompetitionId());
        player.setCurrentClubName(dto.getCurrentClubName());
        player.setMarketValueInEur(dto.getMarketValueInEur());
        player.setHighestMarketValueInEur(dto.getHighestMarketValueInEur());

        return player;

    }
}

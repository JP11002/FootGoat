package org.footgoat.model;

import jakarta.persistence.Column;
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

    private String playerSlug;

    private String playerName;

    @Column(length = 500)
    private String playerImageUrl;

    private String nameInHomeCountry;

    private LocalDate dateOfBirth;

    private String placeOfBirth;

    private String countryOfBirth;

    private Integer height;

    private String citizenship;

    private String position;

    private String mainPosition;
}
package org.footgoat.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Club {

    @Id
    private Long clubId;

    private String clubSlug;

    private String clubName;

    @Column(length = 500)
    private String logoUrl;

    private String countryName;

    private String competitionId;

    private String competitionSlug;

    private String competitionName;

    private String clubDivision;
}

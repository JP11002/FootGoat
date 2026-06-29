package org.footgoat.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlayerPerformance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;

    private String seasonName;

    private String competitionId;

    private String competitionName;

    private Long teamId;

    private String teamName;

    private Integer nbInGroup;

    private Integer nbOnPitch;

    private Integer goals;

    private Integer assists;
}

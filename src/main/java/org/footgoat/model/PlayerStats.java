package org.footgoat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlayerStats {

    @Id
    private Long playerId;

    private Integer goals;

    private Integer assists;

    private Integer internationalGoals;

    private Integer totalGoals;

}
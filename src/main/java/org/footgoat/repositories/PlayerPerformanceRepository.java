package org.footgoat.repositories;

import org.footgoat.model.PlayerPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PlayerPerformanceRepository extends JpaRepository<PlayerPerformance, Long> {
}

package org.example.repository;

import org.example.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonsRepository extends JpaRepository<Season, Integer> {

}

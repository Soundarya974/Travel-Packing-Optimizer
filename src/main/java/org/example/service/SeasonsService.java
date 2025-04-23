package org.example.service;

import java.util.List;

import org.example.model.Season;
import org.example.repository.SeasonsRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonsService {

    private final SeasonsRepository seasonsRepository;

    public SeasonsService(SeasonsRepository seasonsRepository) {
        this.seasonsRepository = seasonsRepository;
    }

    public List<Season> getSeasons() {
        return seasonsRepository.findAll();
    }

}

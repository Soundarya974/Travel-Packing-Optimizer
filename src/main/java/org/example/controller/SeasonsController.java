package org.example.controller;

import java.io.IOException;
import java.util.List;

import org.example.model.Season;
import org.example.service.SeasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seasons")
public class SeasonsController {
    
    @Autowired
    private SeasonsService seasonsService;

    @GetMapping
    public List<Season> getDefaultItems() throws IOException {
        return seasonsService.getSeasons();
    }
}

package org.example.controller;

import java.io.IOException;
import java.util.List;

import org.example.model.TravelItem;
import org.example.service.TravelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemsController {
    
    @Autowired
    private TravelItemService travelItemService;

    @GetMapping("/defaults")
    public List<TravelItem> getDefaultItems() throws IOException {
        return travelItemService.getTravelItemsByTravelType(1);
    }

    @GetMapping("/suggestions")
    public List<TravelItem> getSuggestedItems(@RequestParam("travelTypeId") int travelTypeId, @RequestParam("seasonId") int seasonId)
    throws IOException {
        return travelItemService.getTravelItemsByTravelTypeAndSeason(travelTypeId, seasonId);
    }
}

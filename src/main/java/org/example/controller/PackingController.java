package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.TravelInput;
import org.example.model.TravelItem;

import org.example.service.PackingService;
import org.example.service.TravelItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/packing")
public class PackingController {

    @Autowired
    private PackingService packingService;

    @Autowired
    private TravelItemService travelItemService;

    @PostMapping
    public Map<String, List<TravelItem>> optimize(@RequestBody TravelInput input) {
        return packingService.optimizePacking(input.getItems(), input.getMaxWeight());
    }

    @GetMapping("/defaults")
    public List<TravelItem> getDefaultItems() throws IOException {
        return travelItemService.getTravelItemsByTravelType(1);

    }


}

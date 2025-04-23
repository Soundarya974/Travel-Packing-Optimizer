package org.example.controller;

import java.util.List;
import java.util.Map;

import org.example.model.TravelInput;
import org.example.model.TravelItem;
import org.example.service.PackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/packing")
public class PackingController {

    @Autowired
    private PackingService packingService;

    @PostMapping
    public Map<String, List<TravelItem>> optimize(@RequestBody TravelInput input) {
        return packingService.optimizePacking(input.getItems(), input.getMaxWeight());
    }

}

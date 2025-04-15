package org.example.controller;

import org.example.model.TravelInput;
import org.example.model.TravelItem;

import org.example.service.PackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/packing")
public class PackingController {

    @Autowired
    private PackingService service;

    @PostMapping
    public Map<String, List<TravelItem>> optimize(@RequestBody TravelInput input) {
        return service.optimizePacking(input.getItems(), input.getMaxWeight());}
}

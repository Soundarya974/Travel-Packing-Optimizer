package org.example.controller;

import java.io.IOException;
import java.util.List;

import org.example.model.TravelType;
import org.example.service.TravelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel-types")
public class TravelTypeController {
    
    @Autowired
    private TravelTypeService travelTypeService;

    @GetMapping
    public List<TravelType> getDefaultItems() throws IOException {
        return travelTypeService.getTravelTypes();
    }
}

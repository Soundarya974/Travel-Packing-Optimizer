package org.example.controller;

import java.util.List;
import java.util.Map;

import org.example.model.PackingResult;
import org.example.model.TravelInput;
import org.example.service.PackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/packing")
public class PackingController {

    @Autowired
    private PackingService packingService;

    @PostMapping("/optimal")
    public PackingResult optimizeUsingKnapsack(@RequestBody TravelInput input) {
        return packingService.optimizeUsingKnapsack(input.getItems(), input.getMaxWeight());
    }

    @PostMapping("/greedy/value")
    public PackingResult optimizeUsingGreedyByValue(@RequestBody TravelInput input) {
        return packingService.optimizeUsingGreedyByValue(input.getItems(), input.getMaxWeight());
    }

    @PostMapping("/greedy/ratio")
    public PackingResult optimizeUsingGreedyByRatio(@RequestBody TravelInput input) {
        return packingService.optimizeUsingGreedyByRatio(input.getItems(), input.getMaxWeight());
    }

    @PostMapping("/compare")
    public Map<String, PackingResult> compareAll(@RequestBody TravelInput input) {
        return Map.of(
                "Knapsack Approach", packingService.optimizeUsingKnapsack(input.getItems(), input.getMaxWeight()),
                "Greedy Approach", packingService.optimizeUsingGreedyByValue(input.getItems(), input.getMaxWeight())
        );
    }

}

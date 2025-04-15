package org.example.service;





import org.example.model.TravelItem;
import org.example.solver.GreedySolver;
import org.example.solver.KnapsackSolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PackingService {

    public Map<String, List<TravelItem>> optimizePacking(List<TravelItem> items, int maxWeight) {
        return Map.of(
                "optimal", KnapsackSolver.solve(items, maxWeight),
                "greedyByValue", GreedySolver.solveByValue(items, maxWeight),
                "greedyByRatio", GreedySolver.solveByRatio(items, maxWeight)
        );
    }
}


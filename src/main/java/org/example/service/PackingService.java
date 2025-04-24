package org.example.service;

import org.example.model.PackingResult;
import org.example.model.TravelItem;
import org.example.solver.GreedySolver;
import org.example.solver.KnapsackSolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackingService {

    public PackingResult optimizeUsingKnapsack(List<TravelItem> items, int maxWeight) {
        return KnapsackSolver.solve(items, maxWeight);
    }

    public PackingResult optimizeUsingGreedyByValue(List<TravelItem> items, int maxWeight) {
        return GreedySolver.solveByValue(items, maxWeight);
    }

    public PackingResult optimizeUsingGreedyByRatio(List<TravelItem> items, int maxWeight) {
        return GreedySolver.solveByRatio(items, maxWeight);
    }
}

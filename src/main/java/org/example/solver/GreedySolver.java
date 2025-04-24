package org.example.solver;

import org.example.model.TravelItem;
import org.example.model.PackingResult;

import java.util.*;

public class GreedySolver {

    public static PackingResult solveByValue(List<TravelItem> items, int maxWeight) {
        List<TravelItem> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> b.getImportance() - a.getImportance());
        return greedySelect(sorted, maxWeight);
    }

    public static PackingResult solveByRatio(List<TravelItem> items, int maxWeight) {
        List<TravelItem> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> Double.compare(b.getValueToWeightRatio(), a.getValueToWeightRatio()));
        return greedySelect(sorted, maxWeight);
    }

    private static PackingResult greedySelect(List<TravelItem> sorted, int maxWeight) {
        List<TravelItem> selected = new ArrayList<>();
        int currentWeight = 0;
        int totalImportance = 0;

        for (TravelItem item : sorted) {
            if (currentWeight + item.getWeight() <= maxWeight) {
                selected.add(item);
                currentWeight += item.getWeight();
                totalImportance += item.getImportance();
            }
        }

        return new PackingResult(selected, currentWeight, totalImportance);
    }
}

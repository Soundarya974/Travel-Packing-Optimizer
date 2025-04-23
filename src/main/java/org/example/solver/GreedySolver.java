package  org.example.solver;

import org.example.model.TravelItem;
import java.util.*;

public class GreedySolver {

    public static List<TravelItem> solveByValue(List<TravelItem> items, int maxWeight) {
        List<TravelItem> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> b.getImportance() - a.getImportance());
        return greedySelect(sorted, maxWeight);
    }

    public static List<TravelItem> solveByRatio(List<TravelItem> items, int maxWeight) {
        List<TravelItem> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> Double.compare(b.getValueToWeightRatio(), a.getValueToWeightRatio()));
        return greedySelect(sorted, maxWeight);
    }

    private static List<TravelItem> greedySelect(List<TravelItem> sorted, int maxWeight) {
        List<TravelItem> selected = new ArrayList<>();
        int currentWeight = 0;

        for (TravelItem item : sorted) {
            if (currentWeight + item.getWeight() <= maxWeight) {
                selected.add(item);
                currentWeight += item.getWeight();
            }
        }
        return selected;
    }
}

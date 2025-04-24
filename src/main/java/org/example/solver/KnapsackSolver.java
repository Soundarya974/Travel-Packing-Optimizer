package org.example.solver;

import org.example.model.TravelItem;
import org.example.model.PackingResult;

import java.util.*;

public class KnapsackSolver {

    public static PackingResult solve(List<TravelItem> items, int maxWeight) {
        int n = items.size();
        int[][] dp = new int[n + 1][maxWeight + 1];

        // Build table
        for (int i = 1; i <= n; i++) {
            TravelItem item = items.get(i - 1);
            for (int w = 0; w <= maxWeight; w++) {
                if (item.getWeight() <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], item.getImportance() + dp[i - 1][w - item.getWeight()]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Backtrack to find solution
        List<TravelItem> travelItems = new ArrayList<>();
        int totalWeight = 0;
        int totalImportance = 0;
        int w = maxWeight;

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                TravelItem item = items.get(i - 1);
                travelItems.add(item);
                totalWeight += item.getWeight();
                totalImportance += item.getImportance();
                w -= item.getWeight();
            }
        }

        return new PackingResult(travelItems, totalWeight, totalImportance);
    }
}

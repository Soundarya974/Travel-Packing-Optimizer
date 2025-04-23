package org.example.solver;


import org.example.model.TravelItem;

import java.util.*;

public class KnapsackSolver {

    public static List<TravelItem> solve(List<TravelItem> items, int maxWeight) {
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
        List<TravelItem> result = new ArrayList<>();
        int w = maxWeight;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                TravelItem item = items.get(i - 1);
                result.add(item);
                w -= item.getWeight();
            }
        }

        return result;
    }
}

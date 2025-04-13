package org.example;

import org.example.model.TravelItem;

import org.example.solver.KnapsackSolver;
import org.example.util.PackingUtils;

import java.io.InputStream;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("items.csv");
        PackingUtils.PackingInput input = PackingUtils.loadFromCSV(inputStream);


        if (input.items.isEmpty()) {
            System.out.println("No valid items found. Please check your input file.");
            return;
        }

        int maxWeight = input.maxWeight;
        List<TravelItem> items = input.items;

        var optimal = KnapsackSolver.solve(items, maxWeight);
        PackingUtils.printPackingList("Optimal Packing (DP)", optimal);

    }
}

package org.example.util;

import org.example.model.TravelItem;

import java.io.*;
import java.util.*;


public class PackingUtils {

    public static class PackingInput {
        public int maxWeight;
        public List<TravelItem> items;

        public PackingInput(int maxWeight, List<TravelItem> items) {
            this.maxWeight = maxWeight;
            this.items = items;
        }
    }

    public static PackingInput loadFromCSV(InputStream input) {
        List<TravelItem> items = new ArrayList<>();
        int maxWeight = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;

            // Read max weight
            while ((line = br.readLine()) != null && line.trim().isEmpty()) {
                // Skip empty lines
            }

            if (line != null && line.startsWith("MaxWeight")) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    maxWeight = Integer.parseInt(parts[1].trim());
                } else {
                    throw new IllegalArgumentException("Invalid MaxWeight line.");
                }
            } else {
                throw new IllegalArgumentException("File must start with MaxWeight line.");
            }

            // Skip header
            if ((line = br.readLine()) != null && line.toLowerCase().contains("itemname")) {
                // header line
            }

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.err.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    int weight = Integer.parseInt(parts[2].trim());
                    int value = Integer.parseInt(parts[3].trim());
                    boolean fragile = Boolean.parseBoolean(parts[4].trim());

                    items.add(new TravelItem(id,name, weight, value, fragile));
                } catch (Exception e) {
                    System.err.println("Error parsing line: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return new PackingInput(maxWeight, items);
    }

    public static void printPackingList(String title, List<TravelItem> list) {
        System.out.println("=== " + title + " ===");
        int totalWeight = 0;
        int totalValue = 0;
        for (TravelItem item : list) {
            System.out.println(" - " + item);
            totalWeight += item.getWeight();
            totalValue += item.getImportance();
        }
        System.out.println("Total Weight: " + totalWeight + "kg");
        System.out.println("Total Value: " + totalValue);
        System.out.println();
    }
}

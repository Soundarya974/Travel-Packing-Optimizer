package org.example.model;
import java.util.List;

public class PackingResult {
    private final List<TravelItem> selectedItems;
    private final int totalWeight;
    private final int totalImportance;

    public PackingResult(List<TravelItem> selectedItems, int totalWeight, int totalImportance) {
        this.selectedItems = selectedItems;
        this.totalWeight = totalWeight;
        this.totalImportance = totalImportance;
    }

    public List<TravelItem> getSelectedItems() {
        return selectedItems;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int getTotalImportance() {
        return totalImportance;
    }
}


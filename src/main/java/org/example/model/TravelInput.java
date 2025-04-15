package org.example.model;

import java.util.List;

public class TravelInput {
    private int maxWeight;
    private List<TravelItem> items;

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<TravelItem> getItems() {
        return items;
    }

    public void setItems(List<TravelItem> items) {
        this.items = items;
    }
}


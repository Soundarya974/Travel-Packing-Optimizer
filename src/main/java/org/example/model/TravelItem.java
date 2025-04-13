package org.example.model;

public class TravelItem {
    private final String name;
    private final int weight;  // in kg
    private final int value;   // utility score
    private final boolean fragile;

    public TravelItem(String name, int weight, int value, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.fragile = fragile;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public boolean isFragile() {
        return fragile;
    }

    public double getValueToWeightRatio() {
        return (double) value / weight;
    }

    @Override
    public String toString() {
        return name + " (Weight: " + weight + "kg, Value: " + value + ", Fragile: " + fragile + ")";
    }
}

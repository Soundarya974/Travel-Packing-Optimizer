package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "travelItems")
public class TravelItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int weight;  // in kg
    private int value;   // utility score
    private boolean fragile;


    public TravelItem(int id, String name, int weight, int value, boolean fragile) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.fragile = fragile;
    }

    public TravelItem() {

    }

    public int getId() {
        return id;
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

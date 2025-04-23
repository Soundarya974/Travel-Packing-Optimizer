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
    private int importance;   // utility score
    private boolean isFragile;


    public TravelItem(int id, String name, int weight, int importance, boolean isFragile) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.importance = importance;
        this.isFragile = isFragile;
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

    public int getImportance() {
        return importance;
    }

    public boolean isIsFragile() {
        return isFragile;
    }

    public double getValueToWeightRatio() {
        return (double) importance / weight;
    }

    @Override
    public String toString() {
        return name + " (Weight: " + weight + "kg, Importance: " + importance + ", IsFragile: " + isFragile + ")";
    }
}

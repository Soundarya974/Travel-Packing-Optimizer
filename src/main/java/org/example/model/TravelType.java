package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "travelTypes")
public class TravelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public TravelType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TravelType() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}


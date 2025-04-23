package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Season(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Season() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
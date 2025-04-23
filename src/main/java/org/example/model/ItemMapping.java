package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemMappings")
public class ItemMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "itemId")
    @ManyToOne
    private TravelItem travelItem;

    @JoinColumn(name = "travelTypeId")
    @ManyToOne
    private TravelType travelType;

    @JoinColumn(name = "seasonId")
    @ManyToOne
    private Season season;

}

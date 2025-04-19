package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itemMappings")
public class ItemMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "travelTypeId")
    @ManyToOne
    private TravelType travelType;

    @JoinColumn(name = "itemId")
    @ManyToOne
    private TravelItem travelItem;

}

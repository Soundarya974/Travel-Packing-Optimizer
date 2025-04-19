package org.example.service;

import org.example.model.TravelItem;
import org.example.repository.ItemMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelItemService {

    private final ItemMappingRepository itemMappingRepository;

    public TravelItemService(ItemMappingRepository itemMappingRepository) {
        this.itemMappingRepository = itemMappingRepository;
    }

    public List<TravelItem> getTravelItemsByTravelType(String travelTypeName) {
        return itemMappingRepository.findItemsByTravelTypeName(travelTypeName);
    }


    public List<TravelItem> getTravelItemsByTravelType(int travelTypeId) {
        return itemMappingRepository.findItemsByTravelTypeId(travelTypeId);
    }
}

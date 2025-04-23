package org.example.service;

import java.util.List;

import org.example.model.TravelType;
import org.example.repository.TravelTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TravelTypeService {

    private final TravelTypeRepository travelTypeRepository;

    public TravelTypeService(TravelTypeRepository travelTypeRepository) {
        this.travelTypeRepository = travelTypeRepository;
    }

    public List<TravelType> getTravelTypes() {
        return travelTypeRepository.findAll();
    }

}

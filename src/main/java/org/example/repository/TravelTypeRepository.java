package org.example.repository;

import org.example.model.TravelItem;
import org.example.model.TravelType;
import org.springframework.data.repository.CrudRepository;

public interface TravelTypeRepository extends CrudRepository<TravelType, Integer> {

}

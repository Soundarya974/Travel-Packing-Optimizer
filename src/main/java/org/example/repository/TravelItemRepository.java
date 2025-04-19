package org.example.repository;

import org.example.model.TravelItem;
import org.springframework.data.repository.CrudRepository;

public interface TravelItemRepository extends CrudRepository<TravelItem, Integer> {

}

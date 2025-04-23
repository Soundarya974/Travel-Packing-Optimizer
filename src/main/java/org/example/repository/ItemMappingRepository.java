package org.example.repository;

import java.util.List;

import org.example.model.ItemMapping;
import org.example.model.TravelItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemMappingRepository extends CrudRepository<ItemMapping, Integer> {

    @Query("SELECT im.travelItem FROM ItemMapping im WHERE im.travelType.name = :typeName")
    List<TravelItem> findItemsByTravelTypeName(@Param("typeName") String typeName);

    @Query("SELECT im.travelItem FROM ItemMapping im WHERE im.travelType.id = :typeId")
    List<TravelItem> findItemsByTravelTypeId(@Param("typeId") int typeId);

    @Query("SELECT DISTINCT im.travelItem FROM ItemMapping im WHERE im.travelType.id = :typeId OR im.season.id = :seasonId")
    List<TravelItem> findItemsByTravelTypeIdAndSeasonId(@Param("typeId") int typeId, @Param("seasonId") int seasonId);
}


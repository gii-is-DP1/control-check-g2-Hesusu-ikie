package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
    List<Feeding> findAll();
    @Query("SELECT ft FROM FeedingType ft")
    List<FeedingType> findAllFeedingTypes();
    Optional<Feeding> findById(int id);
    @Query("SELECT ft FROM FeedingType ft WHERE ft.name LIKE :typeName")
    FeedingType findByFeedingType(String typeName);
    Feeding save(Feeding p);
}

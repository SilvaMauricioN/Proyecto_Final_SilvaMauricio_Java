package com.museo.api.museo_api.repository;

import com.museo.api.museo_api.model.ArtObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtObjectRepository extends JpaRepository<ArtObject,Integer> {
  Optional<ArtObject> findByObjectNumber(String objectNumber);
  boolean existsByObjectNumber(String objectNumber);
  boolean existsByObjectNumberAndIdArtObjectNot(String objectNumber, Integer id);
}

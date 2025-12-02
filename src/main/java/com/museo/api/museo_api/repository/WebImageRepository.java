package com.museo.api.museo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.museo.api.museo_api.model.WebImage;
import java.util.List;

@Repository
public interface WebImageRepository extends JpaRepository<WebImage, Integer> {
  List<WebImage> findByArtObject_IdArtObject(Integer idArtObject);
  boolean existsByUrl(String url);
  boolean existsByUrlAndIdWebImageNot(String url, Integer id);
}

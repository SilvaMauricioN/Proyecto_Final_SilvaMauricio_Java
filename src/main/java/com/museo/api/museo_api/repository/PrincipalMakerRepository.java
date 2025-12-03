package com.museo.api.museo_api.repository;
import com.museo.api.museo_api.model.PrincipalMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PrincipalMakerRepository extends JpaRepository<PrincipalMaker,Integer> {
  Optional<PrincipalMaker> findByName(String name);
  boolean existsByName(String name);
  boolean existsByNameAndIdPrincipalMakerNot(String name, Integer id);
}

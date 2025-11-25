package com.museo.api.museo_api.repository;
import com.museo.api.museo_api.model.PrincipalMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrincipalMakerRepository extends JpaRepository<PrincipalMaker,Long> {
  
}

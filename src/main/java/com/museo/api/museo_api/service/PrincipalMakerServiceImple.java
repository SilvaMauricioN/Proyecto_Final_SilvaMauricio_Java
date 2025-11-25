package com.museo.api.museo_api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.museo.api.museo_api.model.PrincipalMaker;
import com.museo.api.museo_api.repository.PrincipalMakerRepository;

@Service
public class PrincipalMakerServiceImple implements PrincipalMakerService {
  private final PrincipalMakerRepository principalMakerRepository;

  @Autowired
  public PrincipalMakerServiceImple(PrincipalMakerRepository principalMakerRepository){
    this.principalMakerRepository = principalMakerRepository;
  }

  public List<PrincipalMaker> fecthPrincipalMaker() {
    return principalMakerRepository.findAll();
  }

  public Optional<PrincipalMaker> getPrincipalMakerById(long idPrincipalMaker) {
    return principalMakerRepository.findById(idPrincipalMaker);
  }

  public PrincipalMaker savePrincipalMaker(PrincipalMaker principalMaker) {
    return principalMakerRepository.save(principalMaker);
  }

  public PrincipalMaker updatePrincipalMaker(long idPrincipalMaker, PrincipalMaker principalMaker) {
    principalMaker.setIdPrincipalMaker(idPrincipalMaker);
    return principalMakerRepository.save(principalMaker);
  }

  public void deletePrincipalMaker(long idPrincipalMaker) {
    principalMakerRepository.deleteById(idPrincipalMaker);
  }  
}

package com.museo.api.museo_api.service;
import java.util.List;
import java.util.Optional;
import com.museo.api.museo_api.model.PrincipalMaker;

public interface PrincipalMakerService {
  
  List<PrincipalMaker> fecthPrincipalMaker();
  Optional<PrincipalMaker> getPrincipalMakerById(long idPrincipalMaker);
  PrincipalMaker savePrincipalMaker(PrincipalMaker principalMaker);
  PrincipalMaker updatePrincipalMaker(long idPrincipalMaker, PrincipalMaker principalMaker);
  void deletePrincipalMaker(long idPrincipalMaker);  
}

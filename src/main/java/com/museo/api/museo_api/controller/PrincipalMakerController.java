package com.museo.api.museo_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.museo.api.museo_api.service.PrincipalMakerService;
import com.museo.api.museo_api.model.PrincipalMaker;
import java.util.List;

@CrossOrigin(origins = "*") 
@RestController 
@RequestMapping("/api/principalmaker") 
public class PrincipalMakerController {
      private final PrincipalMakerService principalMakerService;

    @Autowired
    public PrincipalMakerController(PrincipalMakerService principalMakerService) {
        this.principalMakerService = principalMakerService;
    }

    @GetMapping
    public List<PrincipalMaker> fecthPrincipalMaker() {
        return principalMakerService.fecthPrincipalMaker();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrincipalMaker> getPrincipalMakerById(@PathVariable long id) {
        return principalMakerService.getPrincipalMakerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PrincipalMaker savePrincipalMaker(@RequestBody PrincipalMaker principalMaker) {
        return principalMakerService.savePrincipalMaker(principalMaker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrincipalMaker> updatePrincipalMaker(@PathVariable Long id, @RequestBody PrincipalMaker principalMaker) {
        if (principalMakerService.getPrincipalMakerById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(principalMakerService.updatePrincipalMaker(id, principalMaker));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (principalMakerService.getPrincipalMakerById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        principalMakerService.deletePrincipalMaker(id);
        return ResponseEntity.noContent().build();
    }
  
}

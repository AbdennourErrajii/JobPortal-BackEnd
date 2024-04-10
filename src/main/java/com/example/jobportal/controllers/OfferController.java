package com.example.jobportal.controllers;


import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.services.OffreEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offres-emploi")
@CrossOrigin("*")
public class OfferController {

    @Autowired
    private OffreEmploiService offreEmploiService;

    @GetMapping("/all")
    public ResponseEntity<List<OffreEmploi>> getAllOffers () {
        List<OffreEmploi> ListOffres = offreEmploiService.GetAllOffers();
        return new ResponseEntity<>(ListOffres, HttpStatus.OK);
    }




    @GetMapping()
    public List<OffreEmploi> getAllOffresEmploi() {

        return offreEmploiService.getAllOffresEmploi();
    }

    @GetMapping("/{id}")
    public OffreEmploi getOffreEmploi(@PathVariable Long id) {
        return offreEmploiService.getOffreEmploiById(id).orElse(null);
    }

    @PostMapping
    public OffreEmploi saveOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        return offreEmploiService.saveOffreEmploi(offreEmploi);
    }

    @DeleteMapping("/{id}")
    public boolean supprimerOffreEmploi(@PathVariable Long id) {
        offreEmploiService.deleteOffreEmploi(id);
        return true;
    }

    @PutMapping("/{id}")
    public OffreEmploi modifierOffreEmploi(@PathVariable Long id, @RequestBody OffreEmploi offreEmploi) {
        offreEmploi.setId(id);
        return offreEmploiService.saveOffreEmploi(offreEmploi);
    }

    // Nouvelles méthodes pour la recherche

    @GetMapping("/search/ville-niveauEtude-domaine")
    public List<OffreEmploi> rechercheParVilleNiveauEtudeDomaine(@RequestParam String ville,
                                                                 @RequestParam String niveauEtude,
                                                                 @RequestParam String domaine) {
        return offreEmploiService.getOffresEmploiByVilleNiveauEtudeDomaine(ville, niveauEtude, domaine);
    }

    @GetMapping("/search/ville-niveauEtude-domaine-keyName")
    public List<OffreEmploi> rechercheParVilleNiveauEtudeDomaineEtKeyName(@RequestParam String ville,
                                                                          @RequestParam String niveauEtude,
                                                                          @RequestParam String domaine,
                                                                          @RequestParam String keyName) {
        return offreEmploiService.getOffresEmploiByVilleNiveauEtudeDomaineAndKeyName(ville, niveauEtude, domaine, keyName);
    }

    @GetMapping("/search/ville-domaine-keyName")
    public List<OffreEmploi> rechercheParVilleDomaineEtKeyName(@RequestParam String ville,
                                                               @RequestParam String domaine,
                                                               @RequestParam String keyName) {
        return offreEmploiService.getOffresEmploiByVilleDomaineAndKeyName(ville, domaine, keyName);
    }





    @GetMapping("/search/ville")
    public List<OffreEmploi> rechercheParVille(@RequestParam String ville) {
        return offreEmploiService.getOffresEmploiByVille(ville);
    }

    @GetMapping("/search/niveauEtude")
    public List<OffreEmploi> rechercheParNiveauEtude(@RequestParam String niveauEtude) {
        return offreEmploiService.getOffresEmploiByNiveauEtude(niveauEtude);
    }

    @GetMapping("/search/domaine")
    public List<OffreEmploi> rechercheParDomaine(@RequestParam String domaine) {
        return offreEmploiService.getOffresEmploiByDomaine(domaine);
    }


    @GetMapping("/search/keyName")
    public List<OffreEmploi> rechercheParKeyName(@RequestParam String keyName) {
        return offreEmploiService.getOffresEmploiByKeyName(keyName);
    }



}

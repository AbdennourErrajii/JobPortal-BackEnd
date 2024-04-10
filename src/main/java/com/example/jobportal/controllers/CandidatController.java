package com.example.jobportal.controllers;

import com.example.jobportal.entities.*;
import com.example.jobportal.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidat")
@CrossOrigin("*")
public class CandidatController {


    @Autowired
    private CandidatService candidatService;



    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable Long id) {
        // Rechercher le candidat par son ID à l'aide du service
        Candidat candidat = candidatService.findCandidatById(id);

        if (candidat != null) {
            // Si le candidat est trouvé, retourner le candidat avec le statut HTTP 200 OK
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        } else {
            // Si le candidat n'est pas trouvé, retourner le statut HTTP 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/add")
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat) {
        Candidat newCandidat = candidatService.addCandidat(candidat);
        return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidat>> getAllCandidats () {
        List<Candidat> candidats = candidatService.findAllCandidats();
        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }











    @GetMapping("{id}/offrePostuler")
    public ResponseEntity<List<CandidatureOffre>> getOffresPostuler(@PathVariable("id") Long idCandidat){
        List<CandidatureOffre> offres=new ArrayList<>();
        List<Candidature> candidatures=candidatService.getAllCandidaturePostuler(idCandidat);

        candidatures.forEach(candidature -> {
            CandidatureOffre candidatureOffre=new CandidatureOffre();
            candidatureOffre.setCandidature(candidature);
            candidatureOffre.setOffreEmploi(candidature.getOffreEmploi());
            offres.add(candidatureOffre);
        });
        return new ResponseEntity<>(offres,HttpStatus.OK);
    }

    /*@PostMapping("/{id}/postuler/{idOffre}")
    public ResponseEntity<Candidature> postuler(@PathVariable("id") Long idCandidat,@PathVariable("idOffre") Long idOffre){
        Candidature candidature=candidatService.Postuler(idCandidat,idOffre);
        return new ResponseEntity<>(candidature,HttpStatus.CREATED);
    }*/
    @PostMapping("/{id}/postuler/{idOffre}")
    public ResponseEntity<Candidature> postuler(@PathVariable("id") Long idCandidat,@PathVariable("idOffre") Long idOffre){
        try {
            Candidature candidature = candidatService.Postuler(idCandidat, idOffre);
            return new ResponseEntity<>(candidature, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Gérer les exceptions liées aux arguments invalides
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IllegalStateException e) {
            // Gérer les exceptions liées à l'état invalide
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            // Gérer toutes les autres exceptions imprévues
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping("/delete/candidature/{id}")
    public ResponseEntity<?> deleteCandidature(@PathVariable("id") Long id) {
        candidatService.deleteCandidature(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





    class CandidatureOffre {
        public Candidature candidature;
        public OffreEmploi offreEmploi;

        public void setCandidature(Candidature candidature) {
            this.candidature = candidature;
        }
        public void setOffreEmploi(OffreEmploi offreEmploi) {
            this.offreEmploi = offreEmploi;
        }

        public OffreEmploi getOffreEmploi() {
            return offreEmploi;
        }

        public Candidature getCandidature() {
            return candidature;
        }

    }

}

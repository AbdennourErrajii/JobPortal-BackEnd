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



   @GetMapping("/{id}/formations")
    public ResponseEntity<List<Formation>> getAllFormationsByCandidat(@PathVariable("id") Long idCandidat){
        List<Formation> formations=candidatService.getFormationsByCandidat(idCandidat);
        return new ResponseEntity<>(formations,HttpStatus.OK);
    }

    @GetMapping("/{id}/experiences")
    public ResponseEntity<List<Experience>> getAllExperiencesByCandidat(@PathVariable("id") Long idCandidat){
        List<Experience> experiences=candidatService.getExperiencesByCandidat(idCandidat);
        return new ResponseEntity<>(experiences,HttpStatus.OK);
    }

    @PostMapping("/{id}/add/formation")
    public ResponseEntity<Formation> addFormation(@PathVariable("id") Long idCandidat, @RequestBody Formation formation){
       Formation formation1= candidatService.addFormation(idCandidat,formation);
        return new ResponseEntity<>(formation1,HttpStatus.CREATED);
    }

    @PostMapping("/{id}/add/experience" )
    public ResponseEntity<Experience> addExperience(@PathVariable("id") Long idCandidat, @RequestBody Experience experience){
        Experience experience1= candidatService.addExperience(idCandidat,experience);
        return new ResponseEntity<>(experience1,HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/formation/{id}")
    public ResponseEntity<?> deleteFormation(@PathVariable("id") Long id) {
        candidatService.deleteFormation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/formation")
    public ResponseEntity<Formation> updateFormation(@RequestBody Formation formation) {
        Formation updateFormation = candidatService.updateFormation(formation);
        return new ResponseEntity<>(updateFormation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/experience/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Long id) {
        candidatService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/experience")
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience experience) {
        Experience updateExperience = candidatService.updateExperience(experience);
        return new ResponseEntity<>(updateExperience, HttpStatus.OK);
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

    @PostMapping("/{id}/postuler/{idOffre}")
    public ResponseEntity<Candidature> postuler(@PathVariable("id") Long idCandidat,@PathVariable("idOffre") Long idOffre){
        Candidature candidature=candidatService.Postuler(idCandidat,idOffre);
        return new ResponseEntity<>(candidature,HttpStatus.CREATED);
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

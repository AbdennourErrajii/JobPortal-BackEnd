package com.example.jobportal.controllers;

import com.example.jobportal.entities.Employeur;
import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.services.EmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeur")
@CrossOrigin("*")
public class EmployeurController {


    @Autowired
    private EmployeurService employeurService;

    @GetMapping
    public List<Employeur> getEmployeurs() {
        return employeurService.getAllEmployeurs();
    }

    //@GetMapping
    //public Page<Employeur> getEmployeurs() {
    //  PageRequest pageable = PageRequest.of(0, 5); // Récupère la première page avec 5 éléments
    // return employeurService.getAllEmployeurs(pageable);
    //  }



    @GetMapping("/{id}")
    public Employeur getEmployeur(@PathVariable Long id) {
        return employeurService.getEmployeurById(id).orElse(null);
    }

    @PostMapping("/add")
    public Employeur save(@RequestBody Employeur employeur) {
        return employeurService.saveEmployeur(employeur);
    }

    @DeleteMapping("/{id}")
    public boolean supprimer(@PathVariable Long id) {
        employeurService.deleteEmployeur(id);
        return true;
    }

    @PutMapping("/{id}")
    public Employeur modifier(@PathVariable Long id, @RequestBody Employeur employeur) {
        employeur.setId(id);
        return employeurService.saveEmployeur(employeur);
    }


    @GetMapping("/{id}/offres")
    public List<OffreEmploi> getOffresEmploiByEmployeurId(@PathVariable Long id) {
        return employeurService.getOffresEmploiByEmployeurId(id);
    }

    @GetMapping("/employeurs-with-job-offers")
    public List<Employeur> getAllEmployeursWithJobOffers() {
        return employeurService.getAllEmployeursWithJobOffers();
    }
}

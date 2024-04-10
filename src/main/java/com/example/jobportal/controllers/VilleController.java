package com.example.jobportal.controllers;

import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.entities.Ville;
import com.example.jobportal.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
@CrossOrigin("*")
public class VilleController {
    @Autowired
    private VilleService villeService;

    @GetMapping
    public List<Ville> getVilles() {
        return villeService.getAllVilles();
    }

    @GetMapping("/{id}")
    public Ville getVille(@PathVariable Long id) {
        return villeService.getVilleById(id).orElse(null);
    }



    @GetMapping("/{id}/offresEmploi")
    public List<OffreEmploi> getOffresEmploiByVille(@PathVariable Long id) {
        return villeService.getOffresEmploiByVilleId(id);
    }
}

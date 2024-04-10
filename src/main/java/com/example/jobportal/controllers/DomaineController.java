package com.example.jobportal.controllers;

import com.example.jobportal.entities.Domaine;
import com.example.jobportal.services.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domaines")
@CrossOrigin("*")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @GetMapping
    public List<Domaine> getDomaines() {
        return domaineService.getAllDomaines();
    }

    @GetMapping("/{id}")
    public Domaine getDomaine(@PathVariable Long id) {
        return domaineService.getDomaineById(id).orElse(null);
    }



    //@GetMapping("/{id}/offresEmploi")
    // public List<OffreEmploi> getOffresEmploiByDomaine(@PathVariable Long id) {
    //    return domaineService.getOffresEmploiByVilleId(id);
    // }

}

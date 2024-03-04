package com.example.jobportal.services;

import com.example.jobportal.entities.Employeur;
import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.repositories.EmployeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeurService {
    @Autowired
    private EmployeurRepo employeurRepository;


    //  public Page<Employeur> getAllEmployeurs(Pageable pageable) {
    //    return employeurRepository.findAll(pageable);
    // }

    public Employeur saveEmployeur(Employeur employeur) {
        // You may want to add validation logic or other business logic before saving
        return employeurRepository.save(employeur);

    }

    public List<Employeur> getAllEmployeurs() {
        return employeurRepository.findAll();
    }

    public Optional<Employeur> getEmployeurById(Long employeurId) {
        return employeurRepository.findById(employeurId);
    }



    public List<OffreEmploi> getOffresEmploiByEmployeurId(Long employeurId) {

        return employeurRepository.findAllByEmployeur(employeurId);

    }



    public void deleteEmployeur(Long employeurId) {
        employeurRepository.deleteById(employeurId);
    }



    // You may want to add methods for updating and deleting Employeurs

    // Example of fetching all Employeurs with job offers
    public List<Employeur> getAllEmployeursWithJobOffers() {
        return employeurRepository.getAllWithJobOffers();
    }
}

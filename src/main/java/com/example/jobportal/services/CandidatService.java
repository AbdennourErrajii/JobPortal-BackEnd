package com.example.jobportal.services;

import com.example.jobportal.entities.*;
import com.example.jobportal.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CandidatService {

    @Autowired
    private CandidatRepo candidatRepo;

    @Autowired
    private OffreEmploiRepo offreEmploiRepo;

    @Autowired
    private CandidatureRepo candidatureRepo;




    //***********Gestion d'un Candidat************

    public Candidat addCandidat(Candidat candidat) {
        return candidatRepo.save(candidat);
    }

    public void deleteCandidat(Long id){

        candidatRepo.deleteCandidatById(id);
    }

    public Candidat updateCandidat(Candidat candidat) {

        return candidatRepo.save(candidat);
    }


    public List<Candidat> findAllCandidats() {

        return candidatRepo.findAll();
    }



    //********Gestion des condidature**********

    public Candidature Postuler(Long idCandidat,Long idOffre){
        Candidat candidat =candidatRepo.findCandidatById(idCandidat);
        OffreEmploi offreEmploi= offreEmploiRepo.findOffreEmploiById(idOffre);
        // Vérifier si le candidat et l'offre ne sont pas nuls
        if (candidat == null || offreEmploi == null) {
            throw new IllegalArgumentException("Le candidat et l'offre ne peuvent pas être nuls.");
        }
        // Vérifier si le candidat et l'offre sont associés à des identifiants valides
        if (candidat.getId() == null || offreEmploi.getId() == null) {
            throw new IllegalArgumentException("Les identifiants du candidat et de l'offre doivent être définis.");
        }
        // Vérifier si la candidature n'existe pas déjà pour ce candidat et cette offre
        if (candidatureRepo.existsByCandidatAndOffreEmploi(candidat, offreEmploi)) {
            throw new IllegalStateException("Le candidat a déjà postulé à cette offre d'emploi.");
        }
        // Créer la candidature
        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setOffreEmploi(offreEmploi);
        candidature.setDateCandidature(new Date());
        candidature.setStatut("In progress");
        candidatureRepo.save(candidature);
        return candidature;
    }
    public void deleteCandidature(Long id){

        candidatureRepo.deleteCandidatById(id);
    }

    public List<Candidature> getAllCandidaturePostuler(Long idC){
        return candidatureRepo.findAllByCandidat(idC);
    }




/*
    public List<Offre> GetAllOffers() {
       System.out.println("GetAllOffers");
        return offreRepo.findAll();
    }

    public List<Offre> GetOffreByLocation(String location) {
        return offreRepo.findByVille(location);
    }


*/



    public Candidat findCandidatById(Long id) {
        return candidatRepo.findCandidatById(id);
    }



}

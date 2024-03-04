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

    @Autowired
    private FormationRepo formationRepo;
    @Autowired
    private ExperienceRepo experienceRepo;


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


    //***********Gestion des Formations************

    public Formation addFormation(long idCandidat,Formation formation) {
        Candidat candidat=candidatRepo.findCandidatById(idCandidat);
        formation.setCandidat(candidat);
        formationRepo.save(formation);
        return formation;
    }

    public Formation updateFormation(Formation formation) {
        Long idFormation =formation.getId();
        Formation last=formationRepo.findFormationsById(idFormation);
        formation.setCandidat(last.getCandidat());
        return formationRepo.save(formation);
    }

    public void deleteFormation(Long id) {
        formationRepo.deleteFormationById(id);
    }
    public List<Formation> getFormationsByCandidat(Long idCandidat) {
        return formationRepo.findFormationsByCandidat(idCandidat);
    }

    //***********Gestion des Experiences************

public Experience addExperience(Long idCandidat,Experience experience) {
        Candidat candidat = candidatRepo.findCandidatById(idCandidat);
        experience.setCandidat(candidat);
        experienceRepo.save(experience);
        return experience;
    }
    public Experience updateExperience(Experience experience) {
        Long idExperience =experience.getId();
        Experience last=experienceRepo.findExperienceById(idExperience);
        experience.setCandidat(last.getCandidat());
        return experienceRepo.save(experience);
    }

    public void deleteExperience(Long id) {
        experienceRepo.deleteExperienceById(id);
    }

    public List<Experience> getExperiencesByCandidat(Long idCandidat) {
        return experienceRepo.findExperiencesByCandidat(idCandidat);
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
        candidature.setStatut("En attente");
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






}

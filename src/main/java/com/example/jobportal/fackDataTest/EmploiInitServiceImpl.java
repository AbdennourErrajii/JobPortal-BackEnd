package com.example.jobportal.fackDataTest;

import com.example.jobportal.entities.*;
import com.example.jobportal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class EmploiInitServiceImpl implements IEmploiInitService {

    @Autowired
    private CandidatRepo candidatRepo;
    @Autowired
    private FormationRepo formationRepo;
    @Autowired
    private ExperienceRepo experienceRepo;
    @Autowired
    private EmployeurRepo employeurRepo;
    @Autowired
    private OffreEmploiRepo offreEmploiRepo;
    @Autowired
    private CandidatureRepo candidatureRepo;
    @Autowired
    private CompetenceRepo competenceRepo;

    @Autowired
    private DomaineRepo domaineRepo;

    @Autowired
    private VilleRepo villeRepo;


    @Override
    public void initCandidat() {
    Stream.of("YASSINE","KHALID","ABDENNOUR","Mariem").forEach(nameCandidat -> {
        Candidat candidat = new Candidat();
        candidat.setNom(nameCandidat);
        candidat.setEmail(nameCandidat+"@gmail.com");
        candidat.setMotDePasse(nameCandidat+"123");
        candidat.setAdresse("Adresse "+nameCandidat);
        candidatRepo.save(candidat);
    });

    }

    @Override
    public void initFormation() {
      candidatRepo.findAll().forEach(candidat -> {
          Stream.of("Bac","Bac+2","Bac+3","Bac+4","Bac+5").forEach(nomFormation -> {
              Formation formation = new Formation();
              formation.setDiplome(nomFormation);
              formation.setEtablissement("Etablissement "+nomFormation);
              formation.setDateObtention(new Date());
              formation.setTitre(nomFormation+" Dév");
              formation.setCandidat(candidat);
              formationRepo.save(formation);
          });
      });
    }

    @Override
    public void initExperience() {
        candidatRepo.findAll().forEach(candidat -> {
            Stream.of("Stage","Projet","Emploi").forEach(nomExperience -> {
                Experience experience = new Experience();
                experience.setPosteOccupe(nomExperience);
                experience.setEntreprise("Entreprise Z "+nomExperience);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, -5);
                experience.setDateDebut(calendar.getTime());
                experience.setDateFin(new Date());
                experience.setCandidat(candidat);
                experienceRepo.save(experience);
            });
        });

    }

    @Override
    public void initEmployeur() {
        String [] villes={"Casablanca","Rabat","Marrakech","Fès","Tanger","Kénitra","Agadir"};
        Stream.of("CAPgemeni","ATOS","CGI","SOCIETE GENERAL").forEach(nameEmployeur -> {
            Employeur employeur = new Employeur();
            employeur.setNomEntreprise(nameEmployeur);
            employeur.setEmail(nameEmployeur+"@gmail.com");
            employeur.setMotDePasse(nameEmployeur+"123");
            employeur.setAdresse("Adresse "+nameEmployeur);
            employeur.setVille(villes[new Random().nextInt(villes.length)]);
            employeurRepo.save(employeur);
        });

    }

    @Override
    public void initOffre() {
        employeurRepo.findAll().forEach(employeur -> {
            int[] valeurs = {5000, 6000, 7000, 8000, 10000};
            String[] niveauEtudes = { "Bac+2", "Bac+3", "Bac+5"};
            Stream.of("Développeur","Ingénieur","Architecte","Analyste").forEach(nomOffre -> {
                OffreEmploi offreEmploi = new OffreEmploi();
                offreEmploi.setTitre(nomOffre);
                offreEmploi.setDescription("Description "+nomOffre);
                offreEmploi.setContrat("CDI");
                offreEmploi.setNiveauEtude(niveauEtudes[new Random().nextInt(niveauEtudes.length)]);
                offreEmploi.setDomaine(domaineRepo.findById(new Random().nextLong(13)+1).get());
                offreEmploi.setVille(villeRepo.findById(new Random().nextLong(7)+1).get());
                offreEmploi.setSalaire(String.valueOf(valeurs[new Random().nextInt(valeurs.length)]));
                offreEmploi.setDatePublication(new Date());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, 2);
                offreEmploi.setDateLimiteCandidature(calendar.getTime());
                offreEmploi.setEmployeur(employeur);
                offreEmploiRepo.save(offreEmploi);
            });
        });

    }

    @Override
    public void initCompetence() {
        Stream.of("Java","Spring","Angular","React","NodeJS").forEach(nomCompetence -> {
            Competence competence = new Competence();
            competence.setNom(nomCompetence);
            competenceRepo.save(competence);
        });

    }

    @Override
    public void initCandidature() {
        String [] statut={"En attente","Acceptée","Refusée"};
        candidatRepo.findAll().forEach(candidat -> {
            offreEmploiRepo.findAll().forEach(offreEmploi -> {
                Candidature candidature = new Candidature();
                candidature.setCandidat(candidat);
                candidature.setOffreEmploi(offreEmploi);
                candidature.setDateCandidature(new Date());
                candidature.setStatut(statut[new Random().nextInt(statut.length)]);
                candidatureRepo.save(candidature);
            });
        });

    }

    @Override
    public void initCompetenceToCandidat() {
        List<Competence> competences=competenceRepo.findAll();
        candidatRepo.findAll().forEach(candidat -> {
            candidat.setCompetences(competences);
        });
    }

    @Override
    public void initCompetenceToOffre() {
        List<Competence> competences=competenceRepo.findAll();
        offreEmploiRepo.findAll().forEach(offreEmploi -> {
            offreEmploi.setCompetencesNecessaires(competences);
        });
    }

    @Override
    public void initDomaine() {
        Stream.of("Informatique et technologies de l'information", "Finance et comptabilité",
                "Ressources humaines", "Ingénierie et industrie",
                "Vente et marketing","Services aux entreprises" ,
                "Santé et services sociaux","Éducation et formation",
                "Commerce et distribution","Arts, divertissement et médias",
                "Environnement et développement durable","Tourisme et hôtellerie ",
                "Transport et logistique").forEach(nameDomaine -> {
            domaineRepo.save(new Domaine( nameDomaine));
        });

    }

    @Override
    public void initVille() {
        Stream.of("Casablanca","Rabat","Marrakech","Fès","Tanger","Kénitra","Agadir").forEach(nomVille -> {
            Ville ville = new Ville();
            ville.setNom(nomVille);
            villeRepo.save(ville);
        });

    }
}

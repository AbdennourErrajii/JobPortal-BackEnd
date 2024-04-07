package com.example.jobportal.fackDataTest;

import com.example.jobportal.entities.*;
import com.example.jobportal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class EmploiInitServiceImpl implements IEmploiInitService {

    @Autowired
    private CandidatRepo candidatRepo;

    @Autowired
    private EmployeurRepo employeurRepo;
    @Autowired
    private OffreEmploiRepo offreEmploiRepo;
    @Autowired
    private CandidatureRepo candidatureRepo;


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
        candidat.setTelephone("0654321234");
        candidat.setRole("candidate");
        candidatRepo.save(candidat);
    });

    }




    @Override
    public void initEmployeur() {

        Employeur employeur = new Employeur();
        employeur.setNom("Mouad");
        employeur.setPrenom("Elkoipi");
        employeur.setUsername("Mouad123");
        employeur.setEmail("Mouad@gmail.com");
        employeur.setMotDePasse("GMI123");
        employeur.setRole("employer");
        employeur.setTelephone("0654321234");
        employeurRepo.save(employeur);

        Employeur employeur1 = new Employeur();
        employeur1.setNom("mouha");
        employeur1.setPrenom("eljeem");
        employeur1.setUsername("mouha");
        employeur1.setEmail("MouadRekru@gmail.com");
        employeur1.setMotDePasse("GMI12342024");
        employeur1.setRole("employer");
        employeur1.setTelephone("065430121234");
        employeurRepo.save(employeur1);



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
    public void initCandidature() {
        String [] statut={"In progress","Accepted","Refused"};
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
    public void initVilles() {

        Stream.of("Casablanca", "Fés", "Tanger", "Rabat", "Oujda","Marrakech" , "El Jadida").forEach(nameVille -> {
            villeRepo.save(new Ville( nameVille));
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
}

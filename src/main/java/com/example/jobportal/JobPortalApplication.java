package com.example.jobportal;

import com.example.jobportal.entities.Candidat;

import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.fackDataTest.IEmploiInitService;
import com.example.jobportal.repositories.CandidatRepo;
import com.example.jobportal.repositories.EmployeurRepo;
import com.example.jobportal.repositories.OffreEmploiRepo;

import com.example.jobportal.services.CandidatService;
import com.example.jobportal.services.EmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JobPortalApplication implements CommandLineRunner {

/*
    @Autowired
    private CandidatRepo candidatRepo;
    @Autowired
    private OffreEmploiRepo offreEmploiRepo;

   @Autowired
    private IEmploiInitService iEmploiInitService;
*/
    public static void main(String[] args) {
        SpringApplication.run(JobPortalApplication.class, args);
    }




    @Override
    public void run(String... args) throws Exception {

     /* iEmploiInitService.initCandidat();
        iEmploiInitService.initFormation();
        iEmploiInitService.initExperience();
        iEmploiInitService.initDomaine();
        iEmploiInitService.initVille();
        iEmploiInitService.initEmployeur();
        iEmploiInitService.initOffre();
        iEmploiInitService.initCompetence();
        iEmploiInitService.initCandidature();
        iEmploiInitService.initCompetenceToCandidat();
        iEmploiInitService.initCompetenceToOffre();
*/
        }

    }



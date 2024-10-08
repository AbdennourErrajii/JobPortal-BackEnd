package com.example.jobportal.services;

import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.repositories.OffreEmploiRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OffreEmploiService {

    @Autowired
    private OffreEmploiRepo offreEmploiRepository;



    @Autowired
    public OffreEmploiService(OffreEmploiRepo offreEmploiRepository) {

        this.offreEmploiRepository=offreEmploiRepository;
    }

    public List<OffreEmploi> GetAllOffers() {
        return offreEmploiRepository.findAll();
    }



    public OffreEmploi saveOffreEmploi(OffreEmploi offreEmploi) {
        // You may want to add validation logic or other business logic before saving
        return offreEmploiRepository.save(offreEmploi);
    }

    public List<OffreEmploi> getAllOffresEmploi() {
        return (List<OffreEmploi>) offreEmploiRepository.findAll();
    }

    public Optional<OffreEmploi> getOffreEmploiById(Long offreEmploiId) {
        return offreEmploiRepository.findById(offreEmploiId);
    }

    // Additional custom query methods

    public List<OffreEmploi> getOffresEmploiByKeyName(String keyName) {
        return offreEmploiRepository.findByTitreContainingIgnoreCase(keyName);
    }

    public List<OffreEmploi> getOffresEmploiByNiveauEtude(String niveauEtude) {
        return offreEmploiRepository.findByNiveauEtudeIgnoreCase(niveauEtude);
    }


    public List<OffreEmploi> getOffresEmploiByDomaine(String domaineName) {
        return offreEmploiRepository.findByDomaineNomIgnoreCase(domaineName);
    }

    public List<OffreEmploi> getOffresEmploiByVille(String villeName) {
        return offreEmploiRepository.findByVilleNomIgnoreCase(villeName);
    }

    public List<OffreEmploi> getOffresEmploiByVilleNiveauEtudeDomaine(String ville, String niveauEtude, String domaine) {
        return offreEmploiRepository.findByVilleNomIgnoreCaseAndNiveauEtudeIgnoreCaseAndDomaineNomIgnoreCase(ville, niveauEtude, domaine);
    }

    public List<OffreEmploi> getOffresEmploiByVilleNiveauEtudeDomaineAndKeyName(String ville, String niveauEtude, String domaine, String keyName) {
        return offreEmploiRepository.findByVilleNomIgnoreCaseAndNiveauEtudeIgnoreCaseAndDomaineNomIgnoreCaseAndTitreContainingIgnoreCase(ville, niveauEtude, domaine, keyName);
    }

    public List<OffreEmploi> getOffresEmploiByVilleDomaineAndKeyName(String ville, String domaine, String keyName) {
        return offreEmploiRepository.findByVilleNomIgnoreCaseAndDomaineNomIgnoreCaseAndTitreContainingIgnoreCase(ville, domaine, keyName);
    }

    public void deleteOffreEmploi(Long offreEmploiId) {
        offreEmploiRepository.deleteById(offreEmploiId);
    }


}

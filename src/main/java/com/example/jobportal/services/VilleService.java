package com.example.jobportal.services;

import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.entities.Ville;
import com.example.jobportal.repositories.VilleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    private VilleRepo villeRepository;

    public List<Ville> getAllVilles() {
        return villeRepository.findAll();
    }

    public Optional<Ville> getVilleById(Long id) {
        return villeRepository.findById(id);
    }

    public Ville saveVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public void deleteVille(Long id) {
        villeRepository.deleteById(id);
    }

    public List<OffreEmploi> getOffresEmploiByVilleId(Long villeId) {
        return villeRepository.findOffreEmploiById(villeId);
    }

}

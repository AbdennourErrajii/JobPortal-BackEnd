package com.example.jobportal.services;

import com.example.jobportal.entities.CvCandidat;
import com.example.jobportal.repositories.CvCandidatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CvCandidatService {
    @Autowired
    private CvCandidatRepo cvCandidatRepo;

    public List<CvCandidat> getAllCvCandidat() {
        return cvCandidatRepo.findAll();
    }

    public Optional<CvCandidat> getCvCandidatById(Long id) {
        return cvCandidatRepo.findById(id);
    }

    public CvCandidat saveCvCandidat(CvCandidat cv) {
        return cvCandidatRepo.save(cv);
    }

    public CvCandidat UpdateCvCandidat(CvCandidat cv) {
        return cvCandidatRepo.save(cv);
    }

    public void deleteCvCandidat(Long id) {
        cvCandidatRepo.deleteById(id);
    }

    public CvCandidat getCvCandidatByCandidatId(Long id) {
        return cvCandidatRepo.findByCandidatId(id);
    }

}

package com.example.jobportal.repositories;

import com.example.jobportal.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CandidatRepo extends JpaRepository<Candidat, Long> {


    Candidat findCandidatById(Long id);


    void deleteCandidatById(Long id);
}

package com.example.jobportal.repositories;

import com.example.jobportal.entities.Candidat;
import com.example.jobportal.entities.Candidature;
import com.example.jobportal.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface CandidatureRepo extends JpaRepository<Candidature, Long>{

    void deleteCandidatById(Long id);

    @Query("select c from Candidature c where c.candidat.id=:x ")
    List<Candidature> findAllByCandidat(@Param("x")Long idC);

    boolean existsByCandidatAndOffreEmploi(Candidat candidat, OffreEmploi offre);
}

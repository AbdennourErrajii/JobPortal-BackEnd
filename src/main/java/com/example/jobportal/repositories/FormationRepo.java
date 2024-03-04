package com.example.jobportal.repositories;

import com.example.jobportal.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface FormationRepo extends JpaRepository<Formation, Long> {
    void deleteFormationById(Long id);

    @Query("select f from Formation f where f.candidat.id=:x ")
    List<Formation> findFormationsByCandidat(@Param("x") Long idCandidat);

    @Query("select f from Formation f where f.id=:x ")
    Formation findFormationsById(@Param("x") Long idFormation);
}

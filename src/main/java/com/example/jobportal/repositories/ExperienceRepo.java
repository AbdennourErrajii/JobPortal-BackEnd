package com.example.jobportal.repositories;


import com.example.jobportal.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
    void deleteExperienceById(Long id);

    @Query("select e from Experience e where e.candidat.id=:x ")
    List<Experience> findExperiencesByCandidat(@Param("x") Long idCandidat);

    @Query("select e from Experience e where e.id=:x ")
    Experience findExperienceById(@Param("x") Long idExperience);
}

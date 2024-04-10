package com.example.jobportal.repositories;

import com.example.jobportal.entities.OffreEmploi;
import com.example.jobportal.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface VilleRepo extends JpaRepository<Ville, Long> {
    List<OffreEmploi> findOffreEmploiById(Long id);
}

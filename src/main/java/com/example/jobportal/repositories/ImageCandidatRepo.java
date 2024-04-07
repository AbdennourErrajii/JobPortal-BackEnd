package com.example.jobportal.repositories;

import com.example.jobportal.entities.ImageCandidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ImageCandidatRepo extends JpaRepository<ImageCandidat, Long> {

}

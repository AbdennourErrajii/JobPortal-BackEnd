package com.example.jobportal.repositories;

import com.example.jobportal.entities.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface DomaineRepo extends JpaRepository<Domaine, Long>{

}

package com.example.jobportal.repositories;

import com.example.jobportal.entities.Employeur;
import com.example.jobportal.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface EmployeurRepo extends JpaRepository<Employeur, Long> {
    @Query("SELECT DISTINCT e FROM Employeur e LEFT JOIN FETCH e.offresEmploi")
    List<Employeur> getAllWithJobOffers();


    @Query("select O from OffreEmploi O where O.employeur.id = :idC")
    List<OffreEmploi> findAllByEmployeur(@Param("idC") Long id);

}

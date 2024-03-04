package com.example.jobportal.repositories;

import com.example.jobportal.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@RepositoryRestResource
@CrossOrigin("*")
public interface OffreEmploiRepo extends JpaRepository<OffreEmploi, Long> {


    OffreEmploi findOffreEmploiById(Long idOffre);



    List<OffreEmploi> findByTitreContainingIgnoreCase(String keyName);

    List<OffreEmploi> findByNiveauEtudeIgnoreCase(String SL);

    List<OffreEmploi> findByVilleNomIgnoreCase(String villeName);

    List<OffreEmploi> findByDomaineNomIgnoreCase(String villeName);


    List<OffreEmploi> findByVilleNomIgnoreCaseAndNiveauEtudeIgnoreCaseAndDomaineNomIgnoreCase(String villeNom, String niveauEtude, String domaineNom);
    List<OffreEmploi> findByVilleNomIgnoreCaseAndNiveauEtudeIgnoreCaseAndDomaineNomIgnoreCaseAndTitreContainingIgnoreCase(String villeNom, String niveauEtude, String domaineNom, String titre);

    List<OffreEmploi> findByVilleNomIgnoreCaseAndDomaineNomIgnoreCaseAndTitreContainingIgnoreCase(String villeNom, String domaineNom, String titre);

}

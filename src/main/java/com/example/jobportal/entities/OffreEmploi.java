package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreEmploi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String titre;

    private String description;
    @Column(length = 50)
    private String salaire;
    @Column(length = 10)
    private String contrat;

    @Column(length = 50,name = "niveau_etude")
    private String niveauEtude;

    @Temporal(TemporalType.DATE)
    private Date datePublication;
    @Temporal(TemporalType.DATE)
    private Date dateLimiteCandidature;

    //Relation entre (Offre) et (Competence)
    @ManyToMany
    @JoinTable(
            name = "offre_competence",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id"))
    @JsonBackReference
    private List<Competence> competencesNecessaires;

    //Relation entre (Offre) et (Employeur)
    @ManyToOne
    @JsonBackReference
    private Employeur employeur;

    //Relation entre (Offre) et (Domaine)
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonBackReference
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    //Relation entre (Offre) et (Ville)
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonBackReference
    @JoinColumn(name = "ville_id")
    private Ville ville;

}

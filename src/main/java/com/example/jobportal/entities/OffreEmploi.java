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
    @Column(length = 50)
    private String entreprise;
    @Column(length = 50)
    private String Site_web;
    @Column(length = 50,name = "niveau_etude")
    private String niveauEtude;
    @Column(length = 50)
    private String status;
    @Temporal(TemporalType.DATE)
    private Date datePublication;
    @Temporal(TemporalType.DATE)
    private Date dateLimiteCandidature;



//Relation entre (Offre) et (Employeur)
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference("employeur-offre")
    @JoinColumn(name = "employeur_id")
    private Employeur employeur;
//Relation entre (Offre) et (Domaine)
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonBackReference("domaine-offre")
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    //Relation entre (Offre) et (Ville)
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonBackReference("ville-offre")
    @JoinColumn(name = "ville_id")
    private Ville ville;

    //Relation entre (Offre) et (Image)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference("image-offre")
    @JoinColumn(name="img_id")
    private ImageOffre imageOffre;

}

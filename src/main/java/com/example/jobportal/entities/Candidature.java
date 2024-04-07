package com.example.jobportal.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Temporal(TemporalType.DATE)
    private Date dateCandidature;
    @Column(length = 50)
    private String statut;

    //Relation entre (Candidat) et (Candidature)
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    @JsonIgnore
    private Candidat candidat;


    //Relation entre (Offre) et (Candidature)
    @ManyToOne
    @JoinColumn(name = "offre_id")
    @JsonBackReference
    private OffreEmploi offreEmploi;

    public Candidature(Date dateCandidature, String statut, Candidat candidat, OffreEmploi offreEmploi) {
        this.dateCandidature = dateCandidature;
        this.statut = statut;
        this.candidat = candidat;
        this.offreEmploi = offreEmploi;
    }
}

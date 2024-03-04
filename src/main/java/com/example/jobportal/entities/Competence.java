package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competence{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;

    //Relation entre (Candidat) et (Competence)
    @ManyToMany(mappedBy = "competences")

    private List<Candidat> candidats;

    //Relation entre (Offre) et (Competence)
    @ManyToMany(mappedBy = "competencesNecessaires")
    private List<OffreEmploi> offresEmploi;
}

package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domaine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    //Rlation entre Domaine et Offre
    @OneToMany(mappedBy = "domaine")
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@JsonManagedReference("domaine-offre")
    @JsonIgnore
    private List<OffreEmploi> OffreEmploi;


    public Domaine(String nom) {
        this.nom = nom;
    }



}

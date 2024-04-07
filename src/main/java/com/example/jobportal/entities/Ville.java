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
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    //Rlation entre Ville et Offre
    @OneToMany(mappedBy = "ville")
    //  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference("ville-offre")
    private List<OffreEmploi> OffreEmploi;

    public Ville(String nom) {
        this.nom = nom;
    }
}

package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Employeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(length = 50)
    private String nom ;
    @Column(length = 50)
    private String prenom ;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String email ;
    @Column(length = 50)
    private String motDePasse;
    @Column(length = 50)
    private String role;
    @Column(length = 50)
    private String telephone ;

    //Relation entre Employeur et OffreEmploi
    @OneToMany(mappedBy = "employeur" )
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference("employeur-offre")
    private List<OffreEmploi> offresEmploi;

    public Employeur(String nom, String prenom, String username, String email, String motDePasse, String role, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.telephone = telephone;
    }
}

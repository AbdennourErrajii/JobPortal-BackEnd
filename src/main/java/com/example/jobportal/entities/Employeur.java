package com.example.jobportal.entities;

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
    private Long id;
    @Column(length = 50)
    private String nomEntreprise;
    @Column(length = 50)
    private String nom ;
    @Column(length = 50)
    private String prenom ;
    @Column(length = 20)
    private String role;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String motDePasse;
    private byte[] logo; // Stockage du logo en tant que tableau d'octets
    @Column(length = 50)
    private String secteurActivite;
    @Column(length = 50)
    private String ville;
    @Column(length = 100)
    private String adresse;

    @OneToMany(mappedBy = "employeur")
    private List<OffreEmploi> offresEmploi;
}

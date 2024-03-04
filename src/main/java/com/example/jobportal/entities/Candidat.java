package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Candidat implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    @Column(length = 50)
    private String role;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String motDePasse;
    @Column(length = 10)
    private String telephone;
    @Column(length = 100)
    private String adresse;
    @Column(length = 50)
    private String lieuDeResidence;

    private byte[] photo; // Stockage de la photo en tant que tableau d'octets
    private byte[] cv; // Stockage du CV en tant que tableau d'octets
    private String lettreMotivation;

    //Relation entre (Candidate) et (Experience)
    @OneToMany(mappedBy = "candidat")
    @JsonManagedReference
    private List<Experience> experiencesProfessionnelles;

    //Relation entre (Candidate) et (Competence)
    @ManyToMany
    @JoinTable(
            name = "candidat_competence",
            joinColumns = @JoinColumn(name = "candidat_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id"))
    @JsonBackReference
    private List<Competence> competences;

    //Relation entre (Candidate) et (Formation)
    @OneToMany(mappedBy = "candidat")
    @JsonManagedReference
    private List<Formation> formations;

    public String toString() {
        return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
                + motDePasse + ", telephone=" + telephone + ", adresse=" + adresse + ", lieuDeResidence=";

    }


}

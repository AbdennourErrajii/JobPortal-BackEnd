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
    @Column(length = 50)
    private String sexe;
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
    private String lettreMotivation;


    //Relation entre Candidat et CV
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference("cv-candidat")
    @JoinColumn(name="cv_id")
    private CvCandidat cvCandidat ;


    //Relation entre Candidat et ImageCandidat
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference("image-candidat")
    @JoinColumn(name="img_id")

    private ImageCandidat imageCandidat;




    public String toString() {
        return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
                + motDePasse + ", telephone=" + telephone + ", adresse=" + adresse + ", lieuDeResidence=";

    }


}

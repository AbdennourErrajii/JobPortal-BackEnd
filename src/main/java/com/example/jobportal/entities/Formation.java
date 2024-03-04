package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String diplome;
    @Column(length = 50)
    private String titre;
    @Column(length = 50)
    private String etablissement;
    @Column(length = 50)
    private String lieu;
    @Temporal(TemporalType.DATE)
    private Date dateObtention;

    //Relation entre (Candidate) et (Formation)
    @ManyToOne
    @JsonIgnore
    private Candidat candidat;
}

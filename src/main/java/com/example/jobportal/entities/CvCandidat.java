package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvCandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    @Lob
    private byte[] data;

    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "cvCandidat")
    @JsonManagedReference("cv-candidat")
    private Candidat candidat;

    public CvCandidat(String nom, String type, byte[] data) {
        this.nom = nom;
        this.type = type;
        this.data = data;
    }

}

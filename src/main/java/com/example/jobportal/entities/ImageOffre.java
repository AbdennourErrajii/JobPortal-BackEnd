package com.example.jobportal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageOffre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type;
    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] data;
    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "imageOffre")
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference("image-offre")
    private OffreEmploi offreEmploi;

    public ImageOffre(String nom, String type, byte[] data) {
        this.nom = nom;
        this.type = type;
        this.data = data;
    }
}

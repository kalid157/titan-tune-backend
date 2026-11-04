package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID trackingId; // Attention : le mapper attend un String, voir explication plus bas

    private String titre;
    private String imageUrl;
    private String nomArtiste; // Ajouté pour correspondre au mapper
    private UUID artisteTrackingId;
    
    private Boolean isVip; // Ajouté pour correspondre au mapper
    private Boolean isFree; // Ajouté pour correspondre au mapper

    // Méthodes ajoutées pour correspondre aux noms appelés dans votre AlbumMapper
    public String getTitreAlbum() {
        return this.titre;
    }

    public String getImageAlbum() {
        return this.imageUrl;
    }
}
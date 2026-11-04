package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tracking_id_song")
    private UUID trackingId; // Changé de trackingIdSong à trackingId pour correspondre au mapper

    private String titre;
    
    private String audio; // Changé de audioUrl à audio
    
    private String artiste; // Ajouté pour correspondre au mapper
    
    private Integer durationSeconds; // Ajouté pour correspondre au mapper
    
    private Boolean isVip; // Ajouté pour correspondre au mapper

    private UUID albumTrackingId;
    private UUID categorieTrackingId;
    private UUID artisteTrackingId;
}
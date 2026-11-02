package com.titan.tune.domain.model;
import jakarta.persistence.*; import lombok.Data; import java.util.UUID;

@Entity @Data @Table(name="songs")
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID trackingIdSong;
    private String titre; private String audioUrl; 
    private UUID albumTrackingId; private UUID categorieTrackingId; private UUID artisteTrackingId;
}
package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "songs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Song {
    @Id
    @Column(name = "tracking_id", updatable = false, nullable = false)
    private String trackingId;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false, length = 500)
    private String audio;

    @Column(nullable = false)
    private String artiste;

    @Column(name = "album_tracking_id")
    private String albumTrackingId;

    @Column(name = "artiste_tracking_id")
    private String artisteTrackingId;

    @Column(name = "categorie_tracking_id")
    private String categorieTrackingId;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name = "is_vip", nullable = false)
    @Builder.Default
    private Boolean isVip = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void prePersist() {
        if (trackingId == null) trackingId = UUID.randomUUID().toString();
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}

package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "albums")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Album {
    @Id
    @Column(name = "tracking_id", updatable = false, nullable = false)
    private String trackingId;

    @Column(name = "titre_album", nullable = false)
    private String titreAlbum;

    @Column(name = "nom_artiste", nullable = false)
    private String nomArtiste;

    @Column(name = "image_album", length = 500)
    private String imageAlbum;

    @Column(name = "is_free", nullable = false)
    @Builder.Default
    private Boolean isFree = false;

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

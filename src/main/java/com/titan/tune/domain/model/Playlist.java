package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "playlists")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Playlist {
    @Id
    @Column(name = "tracking_id", updatable = false, nullable = false)
    private String trackingId;

    @Column(nullable = false)
    private String titre;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "client_tracking_id", nullable = false)
    private String clientTrackingId;

    @ElementCollection
    @CollectionTable(name = "playlist_songs",
        joinColumns = @JoinColumn(name = "playlist_id"))
    @Column(name = "song_tracking_id")
    @Builder.Default
    private Set<String> songTrackingIds = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void prePersist() {
        if (trackingId == null) trackingId = UUID.randomUUID().toString();
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}


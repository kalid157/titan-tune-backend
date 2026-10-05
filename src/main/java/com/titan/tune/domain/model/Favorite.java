package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "favorites",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"client_tracking_id", "song_tracking_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Favorite {
    @Id
    @Column(name = "tracking_id", updatable = false, nullable = false)
    private String trackingId;

    @Column(name = "client_tracking_id", nullable = false)
    private String clientTrackingId;

    @Column(name = "song_tracking_id", nullable = false)
    private String songTrackingId;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void prePersist() {
        if (trackingId == null) trackingId = UUID.randomUUID().toString();
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}

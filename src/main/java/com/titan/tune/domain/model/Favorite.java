package com.titan.tune.domain.model;
import jakarta.persistence.*; import lombok.Data; import java.time.LocalDateTime; import java.util.UUID;

@Entity @Data @Table(name="favorites")
public class Favorite {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID trackingId;
    private UUID clientTrackingId; private UUID songTrackingId; private LocalDateTime dateAjout = LocalDateTime.now();
}
package com.titan.tune.domain.model;
import jakarta.persistence.*; import lombok.Data; import java.util.UUID;

@Entity @Data @Table(name="albums")
public class Album {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID trackingId;
    private String titre; private String imageUrl; private UUID artisteTrackingId;
}
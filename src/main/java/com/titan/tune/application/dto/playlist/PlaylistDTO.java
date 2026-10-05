package com.titan.tune.application.dto.playlist;

import lombok.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PlaylistDTO {
    private String trackingId;
    private String titre;
    private String imageUrl;
    private String clientTrackingId;
    private Set<String> songTrackingIds;
    private Integer songCount;
}

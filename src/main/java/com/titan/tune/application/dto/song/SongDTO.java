package com.titan.tune.application.dto.song;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongDTO {
    private String trackingId;
    private String titre;
    private String audio;
    private String artiste;
    private String artisteTrackingId;
    private String albumTrackingId;
    private String categorieTrackingId;
    private Integer durationSeconds;
    private Boolean isVip;
}

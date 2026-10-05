package com.titan.tune.application.dto.album;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AlbumDTO {
    private String trackingId;
    private String titreAlbum;
    private String nomArtiste;
    private String imageAlbum;
    private Boolean isFree;
    private Boolean isVip;
    private Integer order;
    private Boolean isOverridden;
}

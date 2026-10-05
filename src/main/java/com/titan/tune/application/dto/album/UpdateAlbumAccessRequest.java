package com.titan.tune.application.dto.album;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UpdateAlbumAccessRequest {
    private Boolean isFree;
    private Boolean isVip;
}

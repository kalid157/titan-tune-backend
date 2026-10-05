package com.titan.tune.application.mapper;

import com.titan.tune.application.dto.album.AlbumDTO;
import com.titan.tune.domain.model.Album;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {
    public AlbumDTO toDTO(Album album, int order) {
        boolean isOverridden = Boolean.TRUE.equals(album.getIsVip())
                || Boolean.TRUE.equals(album.getIsFree());
        boolean effectiveFree;
        boolean effectiveVip;

        if (Boolean.TRUE.equals(album.getIsVip())) {
            effectiveVip = true;
            effectiveFree = false;
        } else if (Boolean.TRUE.equals(album.getIsFree())) {
            effectiveFree = true;
            effectiveVip = false;
        } else {
            effectiveFree = (order == 0);
            effectiveVip = !effectiveFree;
        }

        return AlbumDTO.builder()
            .trackingId(album.getTrackingId())
            .titreAlbum(album.getTitreAlbum())
            .nomArtiste(album.getNomArtiste())
            .imageAlbum(album.getImageAlbum())
            .isFree(effectiveFree)
            .isVip(effectiveVip)
            .order(order)
            .isOverridden(isOverridden)
            .build();
    }
}

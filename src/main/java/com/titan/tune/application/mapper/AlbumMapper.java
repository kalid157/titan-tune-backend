package com.titan.tune.application.mapper;

import com.titan.tune.domain.model.Album;
import com.titan.tune.application.dto.AlbumDTO; // Assurez-vous que ce DTO existe
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {

    public AlbumDTO toDto(Album album) {
        if (album == null) {
            return null;
        }

        AlbumDTO dto = new AlbumDTO();
        
        // LA CORRECTION EST ICI : .toString() convertit l'UUID en String
        if (album.getTrackingId() != null) {
            dto.setId(album.getTrackingId().toString());
        }

        dto.setTitreAlbum(album.getTitreAlbum());
        dto.setNomArtiste(album.getNomArtiste());
        dto.setImageAlbum(album.getImageAlbum());
        dto.setIsVip(album.getIsVip());
        dto.setIsFree(album.getIsFree());
        
        return dto;
    }
}
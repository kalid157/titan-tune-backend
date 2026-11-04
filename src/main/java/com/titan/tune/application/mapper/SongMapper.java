package com.titan.tune.application.mapper;

import com.titan.tune.domain.model.Song;
import com.titan.tune.application.dto.SongDTO; // Assurez-vous que ce DTO existe
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

    public SongDTO toDto(Song song) {
        if (song == null) {
            return null;
        }

        SongDTO dto = new SongDTO();
        
        // LA CORRECTION EST ICI : .toString() convertit l'UUID en String
        if (song.getTrackingId() != null) {
            dto.setId(song.getTrackingId().toString()); 
        }
        
        dto.setTitre(song.getTitre());
        dto.setAudio(song.getAudio());
        dto.setArtiste(song.getArtiste());
        dto.setDurationSeconds(song.getDurationSeconds());
        dto.setIsVip(song.getIsVip());
        
        return dto;
    }
}
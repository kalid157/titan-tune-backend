package com.titan.tune.application.mapper;

import com.titan.tune.application.dto.song.SongDTO;
import com.titan.tune.domain.model.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {
    public SongDTO toDTO(Song song) {
        return SongDTO.builder()
            .trackingId(song.getTrackingId())
            .titre(song.getTitre())
            .audio(song.getAudio())
            .artiste(song.getArtiste())
            .artisteTrackingId(song.getArtisteTrackingId())
            .albumTrackingId(song.getAlbumTrackingId())
            .categorieTrackingId(song.getCategorieTrackingId())
            .durationSeconds(song.getDurationSeconds())
            .isVip(song.getIsVip())
            .build();
    }
}

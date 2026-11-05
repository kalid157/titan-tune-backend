package com.titan.tune.application.mapper;

import com.titan.tune.application.dto.song.SongDTO;
import com.titan.tune.domain.model.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

    public SongDTO toDTO(Song song) {
        return SongDTO.builder()
            .trackingId(toStr(song.getTrackingIdSong()))
            .titre(song.getTitre())
            .audio(song.getAudioUrl())
            .artiste(song.getArtiste())
            .artisteTrackingId(toStr(song.getArtisteTrackingId()))
            .albumTrackingId(toStr(song.getAlbumTrackingId()))
            .categorieTrackingId(toStr(song.getCategorieTrackingId()))
            .durationSeconds(song.getDurationSeconds())
            .isVip(song.getIsVip())
            .build();
    }

    private String toStr(java.util.UUID id) {
        return id == null ? null : id.toString();
    }
}
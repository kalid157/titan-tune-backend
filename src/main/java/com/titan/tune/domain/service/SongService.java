package com.titan.tune.domain.service;

import com.titan.tune.application.dto.song.SongDTO;
import com.titan.tune.application.mapper.SongMapper;
import com.titan.tune.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Transactional(readOnly = true)
    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream()
            .map(songMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongDTO> getSongsByAlbum(String albumId) {
        return songRepository.findByAlbumTrackingId(albumId).stream()
            .map(songMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongDTO> getSongsByArtist(String artisteTrackingId) {
        return songRepository.findByArtisteTrackingId(artisteTrackingId).stream()
            .map(songMapper::toDTO).collect(Collectors.toList());
    }
}

package com.titan.tune.domain.service;

import com.titan.tune.application.dto.playlist.PlaylistDTO;
import com.titan.tune.common.exception.ResourceNotFoundException;
import com.titan.tune.domain.model.Playlist;
import com.titan.tune.domain.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Transactional(readOnly = true)
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.findAll().stream()
            .map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public Playlist createPlaylist(String titre, String clientTrackingId, String imageUrl) {
        Playlist p = Playlist.builder()
            .titre(titre)
            .clientTrackingId(clientTrackingId)
            .imageUrl(imageUrl)
            .build();
        return playlistRepository.save(p);
    }

    @Transactional
    public void addSongToPlaylist(String playlistId, String songId) {
        Playlist p = playlistRepository.findById(playlistId)
            .orElseThrow(() -> new ResourceNotFoundException("Playlist introuvable"));
        p.getSongTrackingIds().add(songId);
        playlistRepository.save(p);
    }

    @Transactional(readOnly = true)
    public List<String> getSongIds(String playlistId) {
        return playlistRepository.findById(playlistId)
            .map(p -> List.copyOf(p.getSongTrackingIds()))
            .orElseThrow(() -> new ResourceNotFoundException("Playlist introuvable"));
    }

    private PlaylistDTO toDTO(Playlist p) {
        return PlaylistDTO.builder()
            .trackingId(p.getTrackingId())
            .titre(p.getTitre())
            .imageUrl(p.getImageUrl())
            .clientTrackingId(p.getClientTrackingId())
            .songTrackingIds(p.getSongTrackingIds())
            .songCount(p.getSongTrackingIds().size())
            .build();
    }
}

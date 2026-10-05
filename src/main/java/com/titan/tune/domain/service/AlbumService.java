package com.titan.tune.domain.service;

import com.titan.tune.application.dto.album.AlbumDTO;
import com.titan.tune.application.mapper.AlbumMapper;
import com.titan.tune.common.exception.ResourceNotFoundException;
import com.titan.tune.domain.model.Album;
import com.titan.tune.domain.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Transactional(readOnly = true)
    public List<AlbumDTO> getAllAlbumsWithAccess() {
        List<Album> all = albumRepository.findAll();

        Map<String, List<Album>> byArtist = all.stream()
            .collect(Collectors.groupingBy(
                a -> a.getNomArtiste().toLowerCase().trim()));

        List<AlbumDTO> result = new ArrayList<>();

        for (List<Album> artistAlbums : byArtist.values()) {
            artistAlbums.sort(Comparator.comparing(Album::getCreatedAt));
            for (int i = 0; i < artistAlbums.size(); i++) {
                result.add(albumMapper.toDTO(artistAlbums.get(i), i));
            }
        }

        result.sort(Comparator.comparing(AlbumDTO::getTitreAlbum));
        return result;
    }

    @Transactional
    public Album updateAccess(String trackingId, Boolean isFree, Boolean isVip) {
        Album album = albumRepository.findById(trackingId)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Album introuvable : " + trackingId));

        if (Boolean.TRUE.equals(isFree)) {
            album.setIsFree(true);
            album.setIsVip(false);
            log.info("🎁 Album '{}' → GRATUIT", album.getTitreAlbum());
        } else if (Boolean.TRUE.equals(isVip)) {
            album.setIsVip(true);
            album.setIsFree(false);
            log.info("🔒 Album '{}' → PREMIUM", album.getTitreAlbum());
        } else {
            album.setIsFree(false);
            album.setIsVip(false);
            log.info("↺ Album '{}' → défaut", album.getTitreAlbum());
        }

        return albumRepository.save(album);
    }
}

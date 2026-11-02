package com.titan.tune.domain.service;
import com.titan.tune.domain.model.Album; import com.titan.tune.domain.repository.AlbumRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import java.util.List; import java.util.UUID;

@Service @RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    public Album save(Album album) { return albumRepository.save(album); }
    public List<Album> getAll() { return albumRepository.findAll(); }
    public List<Album> search(String titre) { return albumRepository.findByTitreContainingIgnoreCase(titre); }
}
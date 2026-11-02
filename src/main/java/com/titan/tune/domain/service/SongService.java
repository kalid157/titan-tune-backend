package com.titan.tune.domain.service;
import com.titan.tune.domain.model.Song; import com.titan.tune.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import java.util.List; import java.util.UUID;

@Service @RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    public Song save(Song song) { return songRepository.save(song); }
    public List<Song> search(String titre) { return songRepository.findByTitreContainingIgnoreCase(titre); }
    public List<Song> getAll() { return songRepository.findAll(); }
    public Song getById(UUID id) { return songRepository.findById(id).orElse(null); }
}
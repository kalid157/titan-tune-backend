package com.titan.tune.domain.service;
import com.titan.tune.domain.model.Playlist; import com.titan.tune.domain.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import java.util.List; import java.util.UUID;

@Service @RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    public Playlist save(Playlist p) { return playlistRepository.save(p); }
    public List<Playlist> getByClient(UUID clientId) { return playlistRepository.findByTrackingIdClient(clientId); }
    public List<Playlist> getAll() { return playlistRepository.findAll(); }
}
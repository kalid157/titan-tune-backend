package com.titan.tune.infrastructure.controller;

import com.titan.tune.application.dto.playlist.PlaylistDTO;
import com.titan.tune.domain.model.Playlist;
import com.titan.tune.domain.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/playlist")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/all")
    public ResponseEntity<List<PlaylistDTO>> getAll() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @PostMapping("/add")
    public ResponseEntity<Playlist> create(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(playlistService.createPlaylist(
            body.get("titre"), body.get("clientTrackingId"), body.get("imageUrl")));
    }

    @PostMapping("/addSong")
    public ResponseEntity<Void> addSong(@RequestBody Map<String, String> body) {
        playlistService.addSongToPlaylist(
            body.get("trackingIdPlaylist"), body.get("trackingIdSong"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}/songs")
    public ResponseEntity<List<String>> getSongs(@PathVariable String playlistId) {
        return ResponseEntity.ok(playlistService.getSongIds(playlistId));
    }
}

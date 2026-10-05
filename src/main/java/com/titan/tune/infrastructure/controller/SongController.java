package com.titan.tune.infrastructure.controller;

import com.titan.tune.application.dto.song.SongDTO;
import com.titan.tune.domain.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SongController {

    private final SongService songService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SongDTO>> getAll() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/getByAlbum/{trackingIdAlbum}")
    public ResponseEntity<List<SongDTO>> getByAlbum(@PathVariable String trackingIdAlbum) {
        return ResponseEntity.ok(songService.getSongsByAlbum(trackingIdAlbum));
    }

    @GetMapping("/getAllForOne/{trackingIdArtiste}")
    public ResponseEntity<List<SongDTO>> getAllForOne(@PathVariable String trackingIdArtiste) {
        return ResponseEntity.ok(songService.getSongsByArtist(trackingIdArtiste));
    }
}

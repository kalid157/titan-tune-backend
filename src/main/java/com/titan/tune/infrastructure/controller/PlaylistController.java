package com.titan.tune.infrastructure.controller;
import com.titan.tune.domain.model.Playlist; import com.titan.tune.domain.service.PlaylistService;
import io.swagger.v3.oas.annotations.tags.Tag; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;

@RestController @RequestMapping("/playlist") @RequiredArgsConstructor @Tag(name = "Playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("/create/{clientId}") public ResponseEntity<Playlist> create(@PathVariable UUID clientId, @RequestBody Playlist p) { p.setTrackingIdClient(clientId); return ResponseEntity.ok(playlistService.save(p)); }
    @GetMapping("/all") public ResponseEntity<List<Playlist>> all() { return ResponseEntity.ok(playlistService.getAll()); }
    @GetMapping("/allForOne/{clientId}") public ResponseEntity<List<Playlist>> forClient(@PathVariable UUID clientId) { return ResponseEntity.ok(playlistService.getByClient(clientId)); }
}
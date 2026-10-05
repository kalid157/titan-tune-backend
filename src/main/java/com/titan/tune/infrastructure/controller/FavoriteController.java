package com.titan.tune.infrastructure.controller;

import com.titan.tune.domain.model.Favorite;
import com.titan.tune.domain.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favoris")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FavoriteController {

    private final FavoriteRepository favoriteRepository;

    @PostMapping
    public ResponseEntity<Favorite> add(@RequestBody Map<String, String> body) {
        String clientId = body.get("ClientTrackingId");
        String songId = body.get("SongTrackingId");

        var existing = favoriteRepository
            .findByClientTrackingIdAndSongTrackingId(clientId, songId);

        if (existing.isPresent()) return ResponseEntity.ok(existing.get());

        Favorite fav = Favorite.builder()
            .clientTrackingId(clientId)
            .songTrackingId(songId)
            .build();

        return ResponseEntity.ok(favoriteRepository.save(fav));
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody Map<String, String> body) {
        favoriteRepository.deleteByClientTrackingIdAndSongTrackingId(
            body.get("ClientTrackingId"), body.get("SongTrackingId"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{clientTrackingId}")
    public ResponseEntity<List<Favorite>> getUserFavorites(
            @PathVariable String clientTrackingId) {
        return ResponseEntity.ok(
            favoriteRepository.findByClientTrackingId(clientTrackingId));
    }
}

package com.titan.tune.infrastructure.controller;
import com.titan.tune.domain.model.Favorite; import com.titan.tune.domain.repository.FavoriteRepository;
import io.swagger.v3.oas.annotations.tags.Tag; import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController @RequestMapping("/favoris") @RequiredArgsConstructor @Tag(name = "favoris")
public class FavoriteController {
    private final FavoriteRepository favoriteRepository;

    // Endpoint à appeler quand on clique sur LIKE
    @PostMapping
    public ResponseEntity<Favorite> ajouterLike(@RequestParam UUID clientTrackingId, @RequestParam UUID songTrackingId) {
        if (favoriteRepository.existsByClientTrackingIdAndSongTrackingId(clientTrackingId, songTrackingId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Favorite f = new Favorite();
        f.setClientTrackingId(clientTrackingId);
        f.setSongTrackingId(songTrackingId);
        return new ResponseEntity<>(favoriteRepository.save(f), HttpStatus.CREATED);
    }

    // Endpoint qui calcule le nombre de likes (like_count)
    @GetMapping("/stats/nbrLikeForOneSong/{trackingIdSong}")
    public ResponseEntity<Long> getLikeCount(@PathVariable UUID trackingIdSong) {
        return ResponseEntity.ok(favoriteRepository.countBySongTrackingId(trackingIdSong));
    }
}
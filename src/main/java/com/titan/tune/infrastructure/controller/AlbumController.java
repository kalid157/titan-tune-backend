package com.titan.tune.infrastructure.controller;

import com.titan.tune.application.dto.album.AlbumDTO;
import com.titan.tune.application.dto.album.UpdateAlbumAccessRequest;
import com.titan.tune.domain.model.Album;
import com.titan.tune.domain.service.AlbumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
@Tag(name = "Albums")
@CrossOrigin(origins = "*")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/all")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbumsWithAccess());
    }

    @PatchMapping("/{trackingId}/access")
    public ResponseEntity<Album> updateAccess(
            @PathVariable String trackingId,
            @RequestBody UpdateAlbumAccessRequest req) {
        return ResponseEntity.ok(
            albumService.updateAccess(trackingId, req.getIsFree(), req.getIsVip()));
    }

    @PatchMapping("/{trackingId}/reset")
    public ResponseEntity<Album> resetAccess(@PathVariable String trackingId) {
        return ResponseEntity.ok(albumService.updateAccess(trackingId, false, false));
    }
}

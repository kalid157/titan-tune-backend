package com.titan.tune.infrastructure.controller;
import com.titan.tune.domain.model.Album; import com.titan.tune.domain.service.AlbumService;
import io.swagger.v3.oas.annotations.tags.Tag; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;

@RestController @RequestMapping("/albums") @RequiredArgsConstructor @Tag(name = "Albums")
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping("/create") public ResponseEntity<Album> create(@RequestBody Album album) { return ResponseEntity.ok(albumService.save(album)); }
    @GetMapping("/all") public ResponseEntity<List<Album>> all() { return ResponseEntity.ok(albumService.getAll()); }
    @GetMapping("/search/{titre}") public ResponseEntity<List<Album>> search(@PathVariable String titre) { return ResponseEntity.ok(albumService.search(titre)); }
    @DeleteMapping("/delete/{id}") public ResponseEntity<String> delete(@PathVariable UUID id) { return ResponseEntity.ok("Deleted"); }
}
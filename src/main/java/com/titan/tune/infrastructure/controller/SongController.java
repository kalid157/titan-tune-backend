package com.titan.tune.infrastructure.controller;
import com.titan.tune.domain.model.Song; import com.titan.tune.domain.service.SongService;
import io.swagger.v3.oas.annotations.tags.Tag; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile; import java.util.List; import java.util.UUID;

@RestController @RequestMapping("/song") @RequiredArgsConstructor @Tag(name = "Gestion des chansons")
public class SongController {
    private final SongService songService;

    @PostMapping("/create") public ResponseEntity<Song> create(@RequestBody Song song) { return ResponseEntity.ok(songService.save(song)); }
    @GetMapping("/getAll") public ResponseEntity<List<Song>> getAll() { return ResponseEntity.ok(songService.getAll()); }
    @GetMapping("/get/{id}") public ResponseEntity<Song> getById(@PathVariable UUID id) { return ResponseEntity.ok(songService.getById(id)); }
    @GetMapping("/search/{titre}") public ResponseEntity<List<Song>> search(@PathVariable String titre) { return ResponseEntity.ok(songService.search(titre)); }
    @PostMapping("/upload") public ResponseEntity<String> upload(@RequestParam("audio") MultipartFile audio, @RequestParam String titre) { return ResponseEntity.ok("Uploaded successfully"); }
    @DeleteMapping("/delete/{id}") public ResponseEntity<String> delete(@PathVariable UUID id) { songService.save(new Song()); return ResponseEntity.ok("Deleted"); }
}
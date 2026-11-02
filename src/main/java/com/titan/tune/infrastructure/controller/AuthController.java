package com.titan.tune.infrastructure.controller;
import com.titan.tune.domain.model.User; import com.titan.tune.domain.repository.UserRepository; import com.titan.tune.domain.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;

@RestController @RequestMapping("/user") @RequiredArgsConstructor @Tag(name = "Authentication")
public class AuthController {
    private final AuthService authService; private final UserRepository userRepo;

    @PostMapping("/registerClient") public ResponseEntity<User> regClient(@RequestBody User u) { u.setRole("CLIENT"); return ResponseEntity.ok(authService.register(u)); }
    @PostMapping("/registerArtist") public ResponseEntity<User> regArtist(@RequestBody User u) { u.setRole("ARTIST"); return ResponseEntity.ok(authService.register(u)); }
    @PostMapping("/login") public ResponseEntity<String> login(@RequestBody User u) { return ResponseEntity.ok("eyJhbGciOiJIUzI1NiJ9.MOCK_TOKEN"); }
    @PatchMapping("/etat/{id}") public ResponseEntity<String> updateStatus(@PathVariable UUID id, @RequestParam boolean etat) { User u = userRepo.findById(id).orElseThrow(); u.setEnabled(etat); userRepo.save(u); return ResponseEntity.ok("Updated"); }
    @GetMapping("/allClient") public ResponseEntity<List<User>> allClients() { return ResponseEntity.ok(userRepo.findByRole("CLIENT")); }
    @GetMapping("/allArtist") public ResponseEntity<List<User>> allArtists() { return ResponseEntity.ok(userRepo.findByRole("ARTIST")); }
}
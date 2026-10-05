package com.titan.tune.domain.service;

import com.titan.tune.application.dto.auth.AuthResponse;
import com.titan.tune.application.dto.auth.LoginRequest;
import com.titan.tune.application.dto.auth.RegisterRequest;
import com.titan.tune.common.exception.BusinessException;
import com.titan.tune.domain.model.User;
import com.titan.tune.domain.repository.UserRepository;
import com.titan.tune.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public AuthResponse register(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new BusinessException("Cet email est déjà utilisé");
        }

        User user = User.builder()
            .email(req.getEmail())
            .password(passwordEncoder.encode(req.getPassword()))
            .firstName(req.getFirstName())
            .lastName(req.getLastName())
            .phone(req.getPhone())
            .build();

        userRepository.save(user);
        log.info("✅ Nouvel utilisateur: {}", user.getEmail());

        return buildAuthResponse(user);
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail())
            .orElseThrow(() -> new BusinessException("Email ou mot de passe incorrect"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new BusinessException("Email ou mot de passe incorrect");
        }

        log.info("✅ Login: {}", user.getEmail());
        return buildAuthResponse(user);
    }

    private AuthResponse buildAuthResponse(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("trackingId", user.getTrackingId());

        String token = jwtService.generateToken(user.getEmail(), claims);

        return AuthResponse.builder()
            .token(token)
            .id(user.getTrackingId())
            .trackingId(user.getTrackingId())
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .phone(user.getPhone())
            .isPremium(user.getIsPremium())
            .type("Bearer")
            .build();
    }
}

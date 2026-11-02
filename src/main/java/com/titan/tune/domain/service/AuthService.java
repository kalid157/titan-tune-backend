package com.titan.tune.domain.service;
import com.titan.tune.domain.model.User; import com.titan.tune.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository; private final PasswordEncoder passwordEncoder;
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        return userRepository.save(user);
    }
}
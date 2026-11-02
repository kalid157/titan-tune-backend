package com.titan.tune.domain.repository;
import com.titan.tune.domain.model.User; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*; import java.util.UUID;
public interface UserRepository extends JpaRepository<User, UUID> { 
    Optional<User> findByEmail(String email); 
    List<User> findByRole(String role);
}
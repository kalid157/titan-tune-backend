package com.titan.tune.domain.repository;
import com.titan.tune.domain.model.Playlist; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*; import java.util.UUID;
public interface PlaylistRepository extends JpaRepository<Playlist, UUID> { 
    List<Playlist> findByTrackingIdClient(UUID clientId); 
}
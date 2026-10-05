package com.titan.tune.domain.repository;

import com.titan.tune.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
    List<Playlist> findByClientTrackingId(String clientTrackingId);
}


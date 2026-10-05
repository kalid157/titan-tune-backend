package com.titan.tune.domain.repository;

import com.titan.tune.domain.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findByClientTrackingId(String clientTrackingId);
    Optional<Favorite> findByClientTrackingIdAndSongTrackingId(
        String clientTrackingId, String songTrackingId);
    void deleteByClientTrackingIdAndSongTrackingId(
        String clientTrackingId, String songTrackingId);
    long countBySongTrackingId(String songTrackingId);
}

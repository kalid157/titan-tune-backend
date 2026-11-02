package com.titan.tune.domain.repository;
import com.titan.tune.domain.model.Favorite; import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
    boolean existsByClientTrackingIdAndSongTrackingId(UUID clientId, UUID songId);
    long countBySongTrackingId(UUID songId); // <--- L'incrémentation se fait ici
    
    @Query("SELECT f.songTrackingId FROM Favorite f GROUP BY f.songTrackingId ORDER BY COUNT(f) DESC LIMIT 1")
    UUID findTopSongIdByLikes();
}
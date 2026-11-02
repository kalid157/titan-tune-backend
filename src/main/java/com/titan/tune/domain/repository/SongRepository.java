package com.titan.tune.domain.repository;
import com.titan.tune.domain.model.Song; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*; import java.util.UUID;
public interface SongRepository extends JpaRepository<Song, UUID> { 
    List<Song> findByTitreContainingIgnoreCase(String titre); 
    List<Song> findByAlbumTrackingId(UUID albumId);
    List<Song> findByArtisteTrackingId(UUID artisteId);
}
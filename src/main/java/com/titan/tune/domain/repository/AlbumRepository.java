package com.titan.tune.domain.repository;
import com.titan.tune.domain.model.Album; import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*; import java.util.UUID;
public interface AlbumRepository extends JpaRepository<Album, UUID> { 
    List<Album> findByTitreContainingIgnoreCase(String titre); 
}
package com.titan.tune.domain.repository;

import com.titan.tune.domain.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, String> {
    List<Album> findAllByOrderByTitreAlbumAsc();
    List<Album> findByNomArtisteIgnoreCaseOrderByCreatedAtAsc(String nomArtiste);
}

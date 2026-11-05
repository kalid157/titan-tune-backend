package com.titan.tune.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "albums")
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue
    private UUID id;

    private String titreAlbum;
    private String nomArtiste;
    private String imageAlbum;

    private Boolean isVip;
    private Boolean isFree;
}

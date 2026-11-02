package com.titan.tune.domain.model;
import jakarta.persistence.*; import lombok.Data; import java.util.*;

@Entity @Data @Table(name="playlists")
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID trackingId;
    private String titre; private UUID trackingIdClient; private String visibilite;
    @ManyToMany @JoinTable(name="playlist_songs", joinColumns=@JoinColumn(name="playlist_id"), inverseJoinColumns=@JoinColumn(name="song_id"))
    private List<Song> songs = new ArrayList<>();
}
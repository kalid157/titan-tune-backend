-- UTILISATEURS
CREATE TABLE users (
    tracking_id  UUID PRIMARY KEY,
    first_name   VARCHAR(255),
    last_name    VARCHAR(255),
    email        VARCHAR(255) UNIQUE NOT NULL,
    password     VARCHAR(255) NOT NULL,
    phone        VARCHAR(50),
    enabled      BOOLEAN DEFAULT FALSE,
    role         VARCHAR(50),
    alias        VARCHAR(255),
    description  TEXT
);

-- CATEGORIES
CREATE TABLE categories (
    tracking_id    UUID PRIMARY KEY,
    nom_categorie  VARCHAR(255) NOT NULL
);

-- ALBUMS
CREATE TABLE albums (
    tracking_id          UUID PRIMARY KEY,
    titre                VARCHAR(255) NOT NULL,
    nom_artiste          VARCHAR(255),
    image_url            VARCHAR(255),
    artiste_tracking_id  UUID,
    is_vip               BOOLEAN,
    is_free              BOOLEAN
);

-- CHANSONS
CREATE TABLE songs (
    tracking_id_song      UUID PRIMARY KEY,
    titre                 VARCHAR(255) NOT NULL,
    audio_url             VARCHAR(255),
    artiste               VARCHAR(255),
    duration_seconds      INTEGER,
    is_vip                BOOLEAN DEFAULT FALSE,
    album_tracking_id     UUID,
    categorie_tracking_id UUID,
    artiste_tracking_id   UUID
);

-- FAVORIS
CREATE TABLE favoris (
    tracking_id         UUID PRIMARY KEY,
    client_tracking_id  UUID,
    song_tracking_id    UUID,
    date_ajout          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- PLAYLISTS
CREATE TABLE playlists (
    tracking_id         UUID PRIMARY KEY,
    titre               VARCHAR(255),
    tracking_id_client  UUID,
    visibilite          VARCHAR(50)
);

CREATE TABLE playlist_songs (
    playlist_id  UUID NOT NULL REFERENCES playlists(tracking_id) ON DELETE CASCADE,
    song_id      UUID NOT NULL,
    PRIMARY KEY (playlist_id, song_id)
);

-- ECOUTES
CREATE TABLE ecoutes (
    tracking_id       UUID PRIMARY KEY,
    tracking_id_user  UUID,
    tracking_id_song  UUID,
    date_ecoute       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- SUIVIS
CREATE TABLE suivis (
    tracking_id           UUID PRIMARY KEY,
    tracking_id_follower  UUID,
    tracking_id_artiste   UUID,
    UNIQUE (tracking_id_follower, tracking_id_artiste)
);

-- INDEX
CREATE INDEX idx_songs_album      ON songs(album_tracking_id);
CREATE INDEX idx_songs_categorie  ON songs(categorie_tracking_id);
CREATE INDEX idx_songs_artiste    ON songs(artiste_tracking_id);
CREATE INDEX idx_favoris_client   ON favoris(client_tracking_id);
CREATE INDEX idx_playlists_client ON playlists(tracking_id_client);
CREATE INDEX idx_ecoutes_user     ON ecoutes(tracking_id_user);
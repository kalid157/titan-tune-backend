CREATE TABLE IF NOT EXISTS users (
    tracking_id      VARCHAR(36) PRIMARY KEY,
    email            VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255) NOT NULL,
    first_name       VARCHAR(100),
    last_name        VARCHAR(100),
    phone            VARCHAR(30),
    avatar_url       VARCHAR(500),
    is_premium       BOOLEAN NOT NULL DEFAULT FALSE,
    premium_plan     VARCHAR(50),
    monthly_price    DOUBLE PRECISION DEFAULT 0.0,
    role             VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at       TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_user_email ON users(email);

CREATE TABLE IF NOT EXISTS albums (
    tracking_id      VARCHAR(36) PRIMARY KEY,
    titre_album      VARCHAR(255) NOT NULL,
    nom_artiste      VARCHAR(255) NOT NULL,
    image_album      VARCHAR(500),
    is_free          BOOLEAN NOT NULL DEFAULT FALSE,
    is_vip           BOOLEAN NOT NULL DEFAULT FALSE,
    created_at       TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_album_artiste ON albums(nom_artiste);

CREATE TABLE IF NOT EXISTS songs (
    tracking_id             VARCHAR(36) PRIMARY KEY,
    titre                   VARCHAR(255) NOT NULL,
    audio                   VARCHAR(500) NOT NULL,
    artiste                 VARCHAR(255) NOT NULL,
    album_tracking_id       VARCHAR(36),
    artiste_tracking_id     VARCHAR(36),
    categorie_tracking_id   VARCHAR(36),
    duration_seconds        INTEGER,
    is_vip                  BOOLEAN NOT NULL DEFAULT FALSE,
    created_at              TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_song_album ON songs(album_tracking_id);
CREATE INDEX IF NOT EXISTS idx_song_artiste ON songs(artiste);

CREATE TABLE IF NOT EXISTS playlists (
    tracking_id          VARCHAR(36) PRIMARY KEY,
    titre                VARCHAR(255) NOT NULL,
    image_url            VARCHAR(500),
    client_tracking_id   VARCHAR(36) NOT NULL,
    created_at           TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_playlist_client ON playlists(client_tracking_id);

CREATE TABLE IF NOT EXISTS playlist_songs (
    playlist_id       VARCHAR(36) NOT NULL,
    song_tracking_id  VARCHAR(36) NOT NULL,
    PRIMARY KEY (playlist_id, song_tracking_id),
    FOREIGN KEY (playlist_id) REFERENCES playlists(tracking_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS favorites (
    tracking_id          VARCHAR(36) PRIMARY KEY,
    client_tracking_id   VARCHAR(36) NOT NULL,
    song_tracking_id     VARCHAR(36) NOT NULL,
    created_at           TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT uk_fav_client_song UNIQUE (client_tracking_id, song_tracking_id)
);

CREATE INDEX IF NOT EXISTS idx_fav_client ON favorites(client_tracking_id);

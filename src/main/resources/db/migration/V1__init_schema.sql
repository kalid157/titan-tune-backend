CREATE TABLE users (tracking_id UUID PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), email VARCHAR(255) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL, phone VARCHAR(50), enabled BOOLEAN DEFAULT FALSE, role VARCHAR(50), alias VARCHAR(255), description TEXT);
CREATE TABLE categories (tracking_id UUID PRIMARY KEY, nom_categorie VARCHAR(255) NOT NULL);
CREATE TABLE albums (tracking_id UUID PRIMARY KEY, titre VARCHAR(255) NOT NULL, image_url VARCHAR(255), artiste_tracking_id UUID);
CREATE TABLE songs (tracking_id_song UUID PRIMARY KEY, titre VARCHAR(255) NOT NULL, audio_url VARCHAR(255), album_tracking_id UUID, categorie_tracking_id UUID, artiste_tracking_id UUID);
CREATE TABLE favoris (tracking_id UUID PRIMARY KEY, client_tracking_id UUID, song_tracking_id UUID, date_ajout TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE playlists (tracking_id UUID PRIMARY KEY, titre VARCHAR(255), tracking_id_client UUID, visibilite VARCHAR(50));
CREATE TABLE playlist_songs (playlist_id UUID, song_id UUID, PRIMARY KEY (playlist_id, song_id));
CREATE TABLE ecoutes (tracking_id UUID PRIMARY KEY, tracking_id_user UUID, tracking_id_song UUID, date_ecoute TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE suivis (tracking_id UUID PRIMARY KEY, tracking_id_follower UUID, tracking_id_artiste UUID, UNIQUE(tracking_id_follower, tracking_id_artiste));
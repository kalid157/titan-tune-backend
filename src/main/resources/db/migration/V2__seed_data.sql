INSERT INTO albums (tracking_id, titre_album, nom_artiste, image_album, created_at)
VALUES
('alb-tokoos-001', 'Tokoos', 'Fally Ipupa',
 'https://picsum.photos/seed/tokoos/400', NOW() - INTERVAL '30 days'),
('alb-arsenal-002', 'ARSENAL de Belles-Melodies', 'Fally Ipupa',
 'https://picsum.photos/seed/arsenal/400', NOW() - INTERVAL '10 days'),
('alb-happier-004', 'Happier Than Ever', 'Billie Eilish',
 'https://picsum.photos/seed/happier/400', NOW() - INTERVAL '20 days'),
('alb-hitme-005', 'Hit Me Hard and Soft', 'Billie Eilish',
 'https://picsum.photos/seed/hitme/400', NOW() - INTERVAL '3 days')
ON CONFLICT (tracking_id) DO NOTHING;

INSERT INTO songs (tracking_id, titre, audio, artiste, album_tracking_id, duration_seconds)
VALUES
('sng-001', 'Ipupa-Nidja', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3',
 'Fally Ipupa', 'alb-tokoos-001', 333),
('sng-002', 'Juste-une-danse', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3',
 'Fally Ipupa', 'alb-tokoos-001', 302),
('sng-003', 'Bad-Boy', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3',
 'Fally Ipupa', 'alb-arsenal-002', 250),
('sng-005', 'Happier Than Ever', 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3',
 'Billie Eilish', 'alb-happier-004', 295)
ON CONFLICT (tracking_id) DO NOTHING;

CREATE TABLE IF NOT EXISTS languages
(
    id   TINYINT,
    tag  VARCHAR(255) UNIQUE,
    name VARCHAR(255) UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO languages
VALUES (1, 'ar-AR', 'arabic'),
       (2, 'en-EN', 'english'),
       (3, 'fr-FR', 'french');
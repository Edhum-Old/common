-- TODO Change types

CREATE TABLE IF NOT EXISTS nations
(
    id          INT,
    name        VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS nation_profiles
(
    uuid      VARCHAR(255) REFERENCES players (uuid),
    nation_id INT REFERENCES nations (id),
    role_id   TINYINT,
    PRIMARY KEY (uuid)
);

CREATE TABLE IF NOT EXISTS players
(
    uuid        VARCHAR(255),
    name        VARCHAR(255),
    group_id    TINYINT,
    language_id TINYINT,
    money       BIGINT,
    PRIMARY KEY (uuid)
);
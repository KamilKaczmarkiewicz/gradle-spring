CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    user_name VARCHAR(100) NOT NULL
);

CREATE TABLE characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    strength INT NOT NULL,
    dexterity INT NOT NULL,
    vitality INT NOT NULL,
    exp INT NOT NULL,
    gold INT NOT NULL,
    attribute_points INT NOT NULL,
    hp INT NOT NULL,
    max_hp INT NOT NULL,
    is_alive BIT NOT NULL,
    lvl INT NOT NULL,
    sex VARCHAR(7) NOT NULL,
    character_class VARCHAR(16) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);



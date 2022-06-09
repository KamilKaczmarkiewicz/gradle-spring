CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);

CREATE TABLE characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lvl INT NOT NULL,
    sex VARCHAR(7) NOT NULL,
    character_class VARCHAR(16) NOT NULL,
    user_id BIGINT NOT NULL
);

ALTER TABLE characters
    ADD CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES users(id);

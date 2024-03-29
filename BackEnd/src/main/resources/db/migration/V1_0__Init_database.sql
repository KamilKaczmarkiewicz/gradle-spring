CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    mail VARCHAR(100) NOT NULL,
    is_account_non_expired BIT NOT NULL,
    is_account_non_locked BIT NOT NULL,
    is_credential_non_expired BIT NOT NULL,
    is_enabled BIT NOT NULL
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

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE privileges (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE users_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE roles_privileges (
    role_id BIGINT NOT NULL,
    privileges_id BIGINT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (privileges_id) REFERENCES privileges(id)
);



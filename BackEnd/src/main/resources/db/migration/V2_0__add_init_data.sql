INSERT INTO users (first_name, last_name, password, user_name, mail, is_account_non_expired, is_account_non_locked, is_credential_non_expired, is_enabled)
VALUES ('Jan', 'Kowalski', '$2a$12$cixRvbRvgJd7Pi7Q.0IP5ub.QiIThQpaE7x3Hk6v2MrN/FNUvwCse', 'user', 'jkowalski@gmail.com', 1, 1, 1, 1);
INSERT INTO users (first_name, last_name, password, user_name, mail, is_account_non_expired, is_account_non_locked, is_credential_non_expired, is_enabled)
VALUES ('Piotr', 'Mokry', '$2a$12$cixRvbRvgJd7Pi7Q.0IP5ub.QiIThQpaE7x3Hk6v2MrN/FNUvwCse', 'piter', 'pmokry@wp.pl', 1, 1, 1, 1);
INSERT INTO users (first_name, last_name, password, user_name, mail, is_account_non_expired, is_account_non_locked, is_credential_non_expired, is_enabled)
VALUES ('Ewa', 'Laska', '$2a$12$cixRvbRvgJd7Pi7Q.0IP5ub.QiIThQpaE7x3Hk6v2MrN/FNUvwCse', 'awe', 'elaska@bing.com', 1, 1, 1, 1);

INSERT INTO characters
(name, lvl, strength, dexterity, vitality, exp, gold, attribute_points, hp, max_hp, is_alive, sex, character_class, user_id)
VALUES ('Niszczyciel', 1, 1, 1, 1, 0, 10, 4, 8, 8, 1, 'MALE', 'PALADIN', 1);
INSERT INTO characters
(name, lvl, strength, dexterity, vitality, exp, gold, attribute_points, hp, max_hp, is_alive, sex, character_class, user_id)
VALUES ('Kams', 1, 1, 1, 1, 0, 10, 4, 8, 8, 1, 'MALE', 'HUNTER', 2);
INSERT INTO characters
(name, lvl, strength, dexterity, vitality, exp, gold, attribute_points, hp, max_hp, is_alive, sex, character_class, user_id)
VALUES ('Kalma', 1, 1, 1, 1, 0, 10, 4, 8, 8, 0, 'MALE', 'MAGE', 2);
INSERT INTO characters
(name, lvl, strength, dexterity, vitality, exp, gold, attribute_points, hp, max_hp, is_alive, sex, character_class, user_id)
VALUES ('Dzikus8', 1, 1, 1, 1, 0, 10, 4, 8, 8, 1, 'MALE', 'HUNTER', 2);
INSERT INTO characters
(name, lvl, strength, dexterity, vitality, exp, gold, attribute_points, hp, max_hp, is_alive, sex, character_class, user_id)
VALUES ('SzybkaElwka', 1, 1, 1, 1, 0, 10, 4, 8, 8, 1, 'FEMALE', 'MAGE', 3);

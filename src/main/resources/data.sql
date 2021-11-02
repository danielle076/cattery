INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled)
VALUES ('backoffice', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('backoffice', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('backoffice', 'ROLE_BACKOFFICE');

INSERT INTO kittens (name, date_born, weight, name_of_mother, name_of_father, family_tree, first_vaccination, second_vaccination)
VALUES
('Frizzle', '15', '0.5', 'Danielle', 'Thierry', 'Okay', '2', '7'),
('Frummel', '10', '1.5', 'Danielle', 'Thierry', 'Hello', '3', '5');
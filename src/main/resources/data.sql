INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled)
VALUES ('backoffice', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled)
VALUES ('danielle', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('backoffice', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('backoffice', 'ROLE_BACKOFFICE');
INSERT INTO authorities (username, authority)
VALUES ('danielle', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('danielle', 'ROLE_BACKOFFICE');
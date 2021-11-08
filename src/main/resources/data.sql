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

INSERT INTO kittens (name, date_of_birth, weight, breed, first_vaccination, second_vaccination)
VALUES ('Frizzle', '2021-05-26', '0.5', 'Birman', 'yes', 'no'),
       ('Frummel', '2021-03-09', '1.5', 'Siamese', 'no', 'no');

INSERT INTO prices (breed_price, first_vaccination_price, second_vaccination_price, kitten_id)
VALUES ('10.00', '20.50', '30.25', 1),
       ('10.00', '20.50', '30.25', 2);

INSERT INTO customers (first_name, last_name, date_of_birth, email, phone_number, which_breed, other_pets)
VALUES ('Danielle', 'van den Akker', '1983-06-28', 'intoyou@gmail.com', '0612345678', 'Birman', 'Cat'),
       ('Simone', 'Lageboom', '1981-03-15', 'simone@gmail.com', '0687654321', 'Ragdoll', 'Dog, cat');

INSERT into address (street_name, house_number, postal_code, home_town, customer_id)
VALUES ('Dorpstraat', '250', '1000AB', 'Amsterdam', 1),
       ('Laan', '10', '1000AB', 'Utrecht', 2);

INSERT INTO catpart (description, price)
VALUES ('Birman', 800),
       ('Siamese', 750),
       ('Ragdoll', 950),
       ('Eerste vaccinatie', 29.50),
       ('Tweede vaccinatie', 24.35);
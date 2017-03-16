CREATE TABLE person(
    id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO person VALUES (1, 'John', 'Doe', 34, '1234');
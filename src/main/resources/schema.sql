create table account (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL
);

INSERT INTO account VALUES (1, 'Sefu', 10000);
INSERT INTO account VALUES (2, 'Eu', 1000);
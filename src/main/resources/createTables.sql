CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL ,
    age INTEGER NOT NULL

);

CREATE TABLE purchases
(
    id BIGSERIAL PRIMARY KEY,
    purchase_item VARCHAR(50) NOT NULL,
    count integer NOT NULL ,
    amount real NOT NULL ,
    purchase_date date NOT NULL ,
    user_id INTEGER,

    FOREIGN KEY (user_id) REFERENCES users (id)
);


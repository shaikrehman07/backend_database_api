CREATE TABLE sector (
    id int primary key,
    name varchar(255)
);

CREATE TABLE userdata (
    name varchar(255) primary key,
    sector int,
    FOREIGN KEY (sector) REFERENCES sector(id)
);
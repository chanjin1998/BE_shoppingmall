SELECT * from member;

CREATE TABLE member (
    id INT PRIMARY KEY,
    userId VARCHAR(20) not null,
    pw VARCHAR(20) not null,
    email VARCHAR(50) not null,
    contact VARCHAR(20) not null,
    name VARCHAR(10) not null,
);
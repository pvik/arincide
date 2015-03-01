CREATE TABLE groups (id INT PRIMARY KEY,
        name VARCHAR(225),
        category INT,
        type INT);

CREATE TABLE forms (id INT PRIMARY KEY,
        name VARCHAR(225),
        type VARCHAR(255));

CREATE TABLE fields (id INT PRIMARY KEY,
        formId INT,
        name VARCHAR(255),
        type VARCHAR(255));

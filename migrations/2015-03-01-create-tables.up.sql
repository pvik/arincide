CREATE TABLE groups (id INT PRIMARY KEY,
        name VARCHAR(225),
        category INT,
        type INT);

CREATE TABLE permissions (groupId INT,
        access INT,
        objectid INT,
        objecttype VARCHAR(50));

CREATE TABLE users (userid INT,
        username VARCHAR(255)        );

CREATE TABLE forms (id INT PRIMARY KEY,
        key VARCHAR(255) UNIQUE,
        name VARCHAR(225),
        owner VARCHAR(255),
        type VARCHAR(255),
        lastupdatetime TIMESTAMP,
        lastchangedby VARCHAR(255));

CREATE TABLE fields (id INT PRIMARY KEY,
        formId INT,
        name VARCHAR(255),
        type VARCHAR(255),
        defaultvalue VARCHAR(255),
        auditoption VARCHAR(50),
        owner VARCHAR(255),
        lastupdatetime TIMESTAMP,
        lastchangedby VARCHAR(255)
        createmode VARCHAR(50));

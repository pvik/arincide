CREATE TABLE groups (id INT PRIMARY KEY,
        name VARCHAR(225),
        category INT,
        type INT);

CREATE TABLE permissions (groupId INT,
        access INT,
        objectkey VARCHAR(255), -- For Field Permission, this will be the formKey||fieldId
        objecttype VARCHAR(50));

CREATE TABLE users (userid INT,
        username VARCHAR(255)        );

CREATE TABLE forms (key VARCHAR(255) PRIMARY KEY,
        name VARCHAR(225),
        owner VARCHAR(255),
        type VARCHAR(255),
        lastupdatetime TIMESTAMP,
        lastchangedby VARCHAR(255));

CREATE TABLE fields (id INT PRIMARY KEY,
        formkey VARCHAR(255),
        name VARCHAR(255),
        type VARCHAR(255),
        defaultvalue VARCHAR(255),
        auditoption VARCHAR(50),
        owner VARCHAR(255),
        lastupdatetime TIMESTAMP,
        lastchangedby VARCHAR(255)
        createmode VARCHAR(50));

CREATE DATABASE demo;

\connect demo

CREATE TABLE countries(
   id SERIAL,
   abbreviation VARCHAR(10) NOT NULL,
   short_name VARCHAR(50) NOT NULL,
   long_name VARCHAR(250) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO countries(abbreviation, short_name, long_name) 
VALUES ('USA', 'United States', 'The United States of America');

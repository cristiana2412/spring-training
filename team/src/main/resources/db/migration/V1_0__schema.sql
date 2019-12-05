CREATE sequence hibernate_sequence;

CREATE TABLE TEAM(
    id int primary key,
    name varchar(255)
);

CREATE TABLE PERSON (
    id int primary key,
    first_name varchar(255),
    last_name varchar(255),
    team_id int references team(id)
);
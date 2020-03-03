CREATE TABLE users (
    id serial PRIMARY KEY,
    name varchar(220) NOT NULL,
    type varchar(50),
    create_date timestamp NOT NULL,
    change_date timestamp
);

CREATE TABLE company (
    id serial PRIMARY KEY,
    name varchar(220),
    user_id integer,
    create_date timestamp NOT NULL,
    change_date timestamp,
    FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE vacancy (
    id serial PRIMARY KEY,
    title varchar(220) NOT NULL,
    company_id integer,
    salary INTEGER,
    description varchar(220),
    contacts varchar(220),
    create_date timestamp NOT NULL,
    change_date timestamp,
    FOREIGN KEY(company_id) REFERENCES company(id)
);

CREATE TABLE resume (
    id serial PRIMARY KEY,
    title varchar(220) NOT NULL,
    user_id integer,
    experience varchar(220),
    contacts varchar(220),
    create_date timestamp NOT NULL,
    change_date timestamp,
    FOREIGN KEY(user_id) REFERENCES users(id)
);


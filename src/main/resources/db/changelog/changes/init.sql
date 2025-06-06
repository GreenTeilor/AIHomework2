--liquibase formatted sql

--changeset system:001-1
CREATE TABLE companies (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    catch_phrase TEXT,
    bs TEXT
);

--changeset system:001-2
CREATE TABLE geo_locations (
    id UUID PRIMARY KEY,
    lat TEXT NOT NULL,
    lng TEXT NOT NULL
);

--changeset system:001-3
CREATE TABLE addresses (
    id UUID PRIMARY KEY,
    street TEXT NOT NULL,
    suite TEXT,
    city TEXT NOT NULL,
    zipcode TEXT NOT NULL,
    geo_id UUID REFERENCES geo_locations(id)
);

--changeset system:001-5
CREATE TABLE authentication (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    role TEXT NOT NULL,
    password_hash TEXT NOT NULL
);

--changeset system:001-4
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    username TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    phone TEXT,
    website TEXT,
    address_id UUID REFERENCES addresses(id),
    company_id UUID REFERENCES companies(id),
    owner_id UUID NOT NULL REFERENCES authentication(id)
);

--rollback DROP TABLE users;
--rollback DROP TABLE addresses;
--rollback DROP TABLE geo_locations;
--rollback DROP TABLE companies; 
create extension if not exists "uuid-ossp";

CREATE TABLE IF NOT EXISTS "ingredient"(
    id  VARCHAR     CONSTRAINT ingredient_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    name    VARCHAR     NOT NULL
);
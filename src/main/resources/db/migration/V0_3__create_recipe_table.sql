create extension if not exists "uuid-ossp";

CREATE TABLE IF NOT EXISTS "recipe"(
    id  VARCHAR     CONSTRAINT recipe_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    name    VARCHAR     NOT NULL,
    readme    VARCHAR     NOT NULL
);
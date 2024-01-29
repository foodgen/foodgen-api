CREATE TABLE IF NOT EXISTS "region"(
    id  VARCHAR     CONSTRAINT region_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    name    VARCHAR     NOT NULL
);
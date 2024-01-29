CREATE TABLE IF NOT EXISTS "allergy"(
    id  VARCHAR     CONSTRAINT allergy_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    user_id    VARCHAR     NOT NULL     CONSTRAINT user_fk  REFERENCES  "user"(id),
    ingredient_id    VARCHAR     NOT NULL     CONSTRAINT ingredient_fk  REFERENCES  "ingredient"(id)
);
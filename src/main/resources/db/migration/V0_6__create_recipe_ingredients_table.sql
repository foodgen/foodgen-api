create extension if not exists "uuid-ossp";

CREATE TABLE IF NOT EXISTS "recipe_ingredients"(
    id  VARCHAR     CONSTRAINT recipe_ingredients_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    recipe_id    VARCHAR     NOT NULL     CONSTRAINT recipe_fk  REFERENCES  "recipe"(id),
    ingredient_id    VARCHAR     NOT NULL     CONSTRAINT ingredient_fk  REFERENCES  "ingredient"(id)
);
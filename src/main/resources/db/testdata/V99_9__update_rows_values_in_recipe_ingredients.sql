WITH temp_table (id, measure) AS (
    VALUES
        ('recipeig15_id', 'recipe8_id_ig1_measure'),
        ('recipeig16_id', 'recipe8_id_ig3_measure'),
        ('recipeig17_id', 'recipe9_id_ig1_measure'),
        ('recipeig18_id', 'recipe9_id_ig3_measure')
) UPDATE "recipe_ingredients"
    SET measure = temp_table.measure
    FROM temp_table WHERE recipe_ingredients.id = temp_table.id;
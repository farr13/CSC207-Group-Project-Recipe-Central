package users.entity;

import users.entity.Ingredient;
import users.entity.Recipe;

import java.util.List;

public class RecipeFactory {

    public static Recipe createRecipe(String name, String instructionsURL, List<Ingredient> ingredients) {
        validateParameters(name, instructionsURL, ingredients);

        Recipe recipe = new Recipe(name, instructionsURL);
        recipe.getIngredients().addAll(ingredients);

        return recipe;
    }

    private static void validateParameters(String name, String instructionsURL, List<Ingredient> ingredients) {
        if (name == null || name.isEmpty() || instructionsURL == null || instructionsURL.isEmpty() || ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("Name, instructions URL, and ingredients are mandatory parameters.");
        }
    }
}

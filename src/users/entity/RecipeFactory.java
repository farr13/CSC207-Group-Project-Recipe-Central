package users.entity;

import java.util.List;

public class RecipeFactory {

    public static Recipe createRecipe(String name, String instructionsURL, List<Ingredient> ingredients) {
        Recipe recipe = new Recipe(name, instructionsURL);
        recipe.getIngredients().addAll(ingredients);
        return recipe;
    }

    public static Recipe createEmptyRecipe(String name, String instructionsURL) {
        return new Recipe(name, instructionsURL);
    }
}

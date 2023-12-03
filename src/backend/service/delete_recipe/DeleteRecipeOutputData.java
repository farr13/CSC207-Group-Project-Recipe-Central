package backend.service.delete_recipe;

import backend.entity.Recipe;

public class DeleteRecipeOutputData {
    private final Recipe[] recipes;

    public DeleteRecipeOutputData(Recipe[] recipes) {
        this.recipes = recipes;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }
}
